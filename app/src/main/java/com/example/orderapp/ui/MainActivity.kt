package com.example.orderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityMainBinding
import com.example.orderapp.ui.fragment.MainFragment
import com.example.orderapp.ui.fragment.ItemFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var tabArray: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        tabArray = resources.getStringArray(R.array.tab_names)

        binding.pager.adapter = object : FragmentStateAdapter (supportFragmentManager,lifecycle){
            override fun getItemCount(): Int {
               return tabArray.size
            }

            override fun createFragment(position: Int): Fragment {
               if(position == 0)
                   return MainFragment()
                else{
                    val fragment = ItemFragment()
                   fragment.arguments = Bundle().apply {
                       putInt("item", position)
                   }
                   return  fragment
               }

            }
        }
        TabLayoutMediator(binding.tabs,binding.pager){tab, position ->
            tab.text = tabArray[position]
        }.attach()

    }

    override fun onBackPressed() {
        if(binding.pager.currentItem != 0){
            binding.pager.currentItem = binding.pager.currentItem-1
        }else
        super.onBackPressed()
    }
}