package com.example.mvvmdemo.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmdemo.R
import com.example.mvvmdemo.databinding.ActivityMainBinding
import com.example.mvvmdemo.screen.listsport.SportsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragmentContainer, SportsFragment.newInstance())
            .commit()
    }
}
