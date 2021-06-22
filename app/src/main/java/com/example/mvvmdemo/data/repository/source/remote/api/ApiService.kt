package com.example.mvvmdemo.data.repository.source.remote.api

import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("all_sports.php")
    suspend fun fetchSports(): SportResponse
}
