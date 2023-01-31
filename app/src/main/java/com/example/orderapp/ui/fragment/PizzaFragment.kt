package com.example.orderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.orderapp.R
import com.example.orderapp.databinding.FragmentPizzaBinding
import com.example.orderapp.model.Pizza
import com.example.orderapp.util.PizzaAdapter


class PizzaFragment : Fragment() {

    private lateinit var binding: FragmentPizzaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPizzaBinding.inflate(layoutInflater,container,false)

        val adapter = PizzaAdapter(Pizza.pizzen)
        binding.pizzaList.adapter = adapter

//        binding.pizzaList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.pizzaList.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)
        binding.pizzaList.layoutManager = GridLayoutManager(activity,2)
        
        adapter.setListener(object : PizzaAdapter.Listener {
            override fun onItemClick(position: Int) {
               val pizza = adapter.pizzen.get(position)
                Toast.makeText(activity, "Es wurde eine Pizza ${pizza.name} ausgewählt", Toast.LENGTH_SHORT).show()
            }

        })

        return binding.root
    }


}