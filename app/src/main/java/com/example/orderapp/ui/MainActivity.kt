package com.example.orderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tabArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        tabArray = resources.getStringArray(R.array.tab_names)
    }
}