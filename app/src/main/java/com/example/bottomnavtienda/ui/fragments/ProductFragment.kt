package com.example.bottomnavtienda.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.ui.listeners.OnProductListener
import com.example.bottomnavtienda.ui.adapters.ProductAdapter
import com.example.bottomnavtienda.data.models.Product
import com.example.bottomnavtienda.databinding.FragmentProductBinding



class ProductFragment : Fragment() {

    private var _binding : FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productManager: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_product, container, false)
        _binding = FragmentProductBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        productAdapter = ProductAdapter(
            listOf(
                Product("producto1","https://image.flaticon.com/icons/png/512/1312/1312091.png","5100","Desc1"),
                Product("producto2","https://image.flaticon.com/icons/png/512/1312/1312091.png","800","Desc2"),
                Product("producto3","https://image.flaticon.com/icons/png/512/1312/1312091.png","8700","Desc3"),
                Product("producto4","https://image.flaticon.com/icons/png/512/1312/1312091.png","9000","Desc4")

            )

        )
        productAdapter.listener = object: OnProductListener {
            override fun onClick(product: Product) {
                Log.d("CLICK",product.name)
                findNavController().navigate(R.id.action_productFragment_to_productDetailFragment)
            }

        }
        productManager = GridLayoutManager(requireContext(),2)
        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager

        }
    }


}