package com.example.mvvmdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.mvvmdemo.data.repository.SportRepositoryImpl
import com.example.mvvmdemo.data.repository.source.SportDataSource
import com.example.mvvmdemo.data.repository.source.remote.SportRemoteImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(Dispatchers.IO) {
            val response = SportRepositoryImpl(SportRemoteImpl()).getListSport()
            Log.d(TAG, "onCreate: ${response}")
        }
    }
}
