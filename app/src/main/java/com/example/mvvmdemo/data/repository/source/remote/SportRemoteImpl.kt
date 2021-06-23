package com.example.mvvmdemo.data.repository.source.remote

import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.api.ApiService
import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse

class SportRemoteImpl(private val apiService: ApiService) : SportDataSource.Remote {

    override suspend fun getSports(): SportResponse {
        return apiService.fetchSports()
    }
}
