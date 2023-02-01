package com.example.orderapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.orderapp.R
import com.example.orderapp.databinding.FragmentDetailBinding
import com.example.orderapp.model.Item


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle :Bundle = arguments?.get("item") as Bundle
        val item: Item? = bundle.getParcelable("item")
        binding.tvName.text = item?.name
        binding.tvDesc.text = "Ein kleiner Text, der das Produkt beschreibt und weitere Informationen liefern soll"
        binding.tvPrice.text = "%.2f %s".format( item?.price, "€")
        binding.imageView.setImageDrawable(requireContext().getDrawable(item!!.imageResource))
    }

}