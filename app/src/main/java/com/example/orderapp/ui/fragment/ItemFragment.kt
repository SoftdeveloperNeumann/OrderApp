package com.example.orderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.orderapp.databinding.FragmentItemBinding
import com.example.orderapp.model.Drink
import com.example.orderapp.model.Pasta
import com.example.orderapp.model.Pizza
import com.example.orderapp.util.ItemAdapter


class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding
    private var itemType: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater,container,false)

        itemType = requireArguments().getInt("item")

        val adapter = when(itemType){
            1 -> ItemAdapter(Pizza.items)
            2 -> ItemAdapter(Pasta.items)
            3 -> ItemAdapter(Drink.items)
            else -> null
        }

        binding.root.adapter = adapter

//        binding.pizzaList.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
//        binding.pizzaList.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.HORIZONTAL)
        binding.root.layoutManager = GridLayoutManager(activity,2)
        
        adapter?.setListener(object : ItemAdapter.Listener {
            override fun onItemClick(position: Int) {
               val item = adapter.items[position]
                Toast.makeText(activity, "Es wurde  ${item.name} ausgewählt", Toast.LENGTH_SHORT).show()

                val fragment = DetailFragment()
                fragment.arguments = Bundle().apply {
//                    putParcelable("item", item)
                }
            }

        })

        return binding.root
    }


}