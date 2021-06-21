package com.example.mvvmdemo.di

import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.SportRemoteImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<SportDataSource.Remote> {
        SportRemoteImpl(get())
    }
}