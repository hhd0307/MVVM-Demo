package com.example.mvvmdemo.di

import com.example.mvvmdemo.data.repository.source.remote.api.ApiService
import com.example.mvvmdemo.data.repository.source.remote.api.ServiceGenerator
import com.example.mvvmdemo.utils.Constant
import org.koin.dsl.module

val networkModule = module {
    single {
        ServiceGenerator.generate(
            baseUrl = Constant.BASE_URL,
            serviceClass = ApiService::class.java
        )
    }
}
