package com.example.mvvmdemo.di

import com.example.mvvmdemo.data.repository.SportRepository
import com.example.mvvmdemo.data.repository.SportRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<SportRepository> {
        SportRepositoryImpl(get())
    }
}
