package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.example.mvvmdemo.data.repository.SportRepository
import com.example.mvvmdemo.data.repository.SportRepositoryImpl
import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.SportRemoteImpl
import com.example.mvvmdemo.di.repositoryModule
import com.example.mvvmdemo.utils.Status
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private val sportViewModel by viewModel<SportsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sportViewModel.sports.observe(this, Observer {
            Log.d(TAG, "onCreate: ${it?.size}")
        })
    }
}
