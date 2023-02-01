package com.example.orderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.tbDetail)
        // erstellt Button um im BackStack einen Schritt zurückzugehen,
        // wichtig hierbei, in der Manifestdatei den Parent anzugeben
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}