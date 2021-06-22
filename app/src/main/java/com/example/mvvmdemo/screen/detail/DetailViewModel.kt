package com.example.mvvmdemo.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmdemo.data.model.Sport

class DetailViewModel : ViewModel() {

    private val _sport = MutableLiveData<Sport>()
    val sport: LiveData<Sport>
        get() = _sport

    fun setSport(data: Sport?) {
        data?.let { _sport.value = it }
    }
}
