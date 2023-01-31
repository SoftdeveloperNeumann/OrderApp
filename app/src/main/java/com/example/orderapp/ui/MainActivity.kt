package com.example.orderapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityMainBinding
import com.example.orderapp.ui.fragment.MainFragment
import com.example.orderapp.ui.fragment.PizzaFragment
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
               val fragment = when(position){
                   0 -> MainFragment()
                   1 -> PizzaFragment()
                   else -> Fragment()
               }
                return  fragment
            }
        }
        TabLayoutMediator(binding.tabs,binding.pager){tab, position ->
            tab.text = tabArray[position]
        }.attach()

    }
}