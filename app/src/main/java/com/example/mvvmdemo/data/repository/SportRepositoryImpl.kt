package com.example.mvvmdemo.data.repository

import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.utils.DataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SportRepositoryImpl(private val remote: SportDataSource.Remote) : SportRepository {

    override suspend fun getListSport(): DataResult<MutableList<Sport>> =
        withContext(Dispatchers.IO) {
            var sportList: MutableList<Sport>
            try {
                remote.getSports().also { sportList = it.sportItems }
                return@withContext DataResult.Success(sportList)
            } catch (ex: Exception) {
                return@withContext DataResult.Error(ex)
            }
        }
}
