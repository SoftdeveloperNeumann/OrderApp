package com.example.orderapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.ShareActionProvider

import androidx.core.view.MenuItemCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.orderapp.R
import com.example.orderapp.databinding.ActivityMainBinding
import com.example.orderapp.ui.fragment.MainFragment
import com.example.orderapp.ui.fragment.ItemFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var shareActionProvider: ShareActionProvider
    private lateinit var binding: ActivityMainBinding
    private lateinit var tabArray: Array<String>

   companion object{private var currentFragment = 0}

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
                currentFragment = position
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

        if(currentFragment != 0)
            binding.pager.setCurrentItem(currentFragment-1)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        val item = menu!!.findItem(R.id.action_share)
        shareActionProvider = MenuItemCompat.getActionProvider(item) as ShareActionProvider
        setShareAction("Das musst du unbedingt kennen lernen")
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_create_order -> startActivity(Intent(this, OrderActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setShareAction(text: String) {
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_TEXT,text)
        shareActionProvider.setShareIntent(shareIntent)
    }


}