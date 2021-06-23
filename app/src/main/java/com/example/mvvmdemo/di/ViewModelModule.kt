package com.example.mvvmdemo.di

import com.example.mvvmdemo.screen.detail.DetailViewModel
import com.example.mvvmdemo.screen.listsport.SportsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SportsViewModel(get()) }

    viewModel { DetailViewModel() }
}
