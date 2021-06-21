package com.example.mvvmdemo.data.repository.source.remote

import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.api.ApiService
import com.example.mvvmdemo.data.repository.source.remote.api.response.SportResponse
import com.example.mvvmdemo.utils.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//class SportRemoteImpl(private val apiService: ApiService) : SportDataSource.Remote {
class SportRemoteImpl() : SportDataSource.Remote {

    override suspend fun getSports(): SportResponse {
        val retrofitBuild = retrofitBuild()
        val res =  retrofitBuild.fetchSports()
        return res
    }

    private fun retrofitBuild(): ApiService {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(TIME_OUT, TimeUnit.MILLISECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    companion object {
        const val TIME_OUT = 20000L
    }
}
