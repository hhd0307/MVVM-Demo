package com.example.mvvmdemo.screen.listsport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.data.repository.SportRepository
import com.example.mvvmdemo.utils.DataResult
import com.example.mvvmdemo.utils.Status
import kotlinx.coroutines.launch

class SportsViewModel(private val sportRepository: SportRepository) : ViewModel() {

    private val _sports = MutableLiveData<MutableList<Sport>>()
    val status = MutableLiveData<Status>()
    val sports: LiveData<MutableList<Sport>>
        get() = _sports

    init {
        getSports()
    }

    private fun getSports() {
        viewModelScope.launch {
            status.value = Status.LOADING
            when (val response = sportRepository.getListSport()) {
                is DataResult.Success -> {
                    _sports.value = response.data
                    status.value = Status.SUCCESS
                }
                is DataResult.Error -> {
                    _sports.value = null
                    status.value = Status.ERROR
                }
            }
        }
    }
}
