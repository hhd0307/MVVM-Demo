package com.example.mvvmdemo.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.screen.listsport.SportsFragment
import com.example.mvvmdemo.screen.listsport.SportsViewModel
import com.example.mvvmdemo.utils.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().add(
            R.id.fragmentContainer, SportsFragment.newInstance()
        ).commit()
    }
}
