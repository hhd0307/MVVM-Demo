package com.example.mvvmdemo.data.repository.source

import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse
import retrofit2.Call

interface SportDataSource {

    interface Remote {
        suspend fun getSports(): SportResponse
    }
}
