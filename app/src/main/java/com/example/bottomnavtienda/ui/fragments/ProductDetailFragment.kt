package com.example.bottomnavtienda.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.databinding.FragmentProductBinding
import com.example.bottomnavtienda.databinding.FragmentProductDetailBinding



class ProductDetailFragment : Fragment() {

    private var _binding : FragmentProductDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_product_detail, container, false)
        _binding = FragmentProductDetailBinding.inflate(inflater,container,false)
        return binding.root
    }


}