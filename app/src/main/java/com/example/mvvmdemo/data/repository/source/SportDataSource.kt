package com.example.mvvmdemo.data.repository.source

import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse

interface SportDataSource {

    interface Remote {
        suspend fun getSports(): SportResponse
    }
}
