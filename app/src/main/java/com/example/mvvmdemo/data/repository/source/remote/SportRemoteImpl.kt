package com.example.mvvmdemo.data.repository.source.remote

import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.api.ApiService
import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse
import com.example.mvvmdemo.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class SportRemoteImpl(private val apiService: ApiService) : SportDataSource.Remote {

    override suspend fun getSports(): SportResponse {
        return apiService.fetchSports()
    }
}
