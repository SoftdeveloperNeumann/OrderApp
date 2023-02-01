package com.example.orderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityDetailBinding
import com.example.orderapp.model.Item
import com.example.orderapp.ui.fragment.DetailFragment

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

        val args = Bundle().apply {
            putParcelable("item", intent.getParcelableExtra<Item>("item"))
        }
        val transaction = supportFragmentManager.beginTransaction()
            .replace(R.id.container_details,DetailFragment::class.java,args)
            .commitNow()
    }
}