package com.example.bottomnavtienda.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.bottomnavtienda.R
import com.example.bottomnavtienda.ui.listeners.OnProductListener
import com.example.bottomnavtienda.ui.adapters.ProductAdapter
import com.example.bottomnavtienda.data.models.Product
import com.example.bottomnavtienda.databinding.FragmentProductBinding
import com.example.bottomnavtienda.ui.viewmodels.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class ProductFragment : Fragment() {

    private var _binding : FragmentProductBinding? = null
    private val binding get() = _binding!!
    private lateinit var productAdapter: ProductAdapter
    private lateinit var productManager: GridLayoutManager

    private val productViewModel: ProductViewModel by sharedViewModel()

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
        productViewModel.loadProducts()
        productAdapter = ProductAdapter(
            listOf()

        )
        productAdapter.listener = object: OnProductListener {
            override fun onClick(product: Product) {
                Log.d("CLICK",product.name!!)
                productViewModel.selectedProduct(product)
                findNavController().navigate(R.id.action_productFragment_to_productDetailFragment)
            }

        }
        productManager = GridLayoutManager(requireContext(),2)
        binding.productRecycler.apply {
            adapter = productAdapter
            layoutManager = productManager

        }
        productViewModel.product.observe(viewLifecycleOwner, Observer { products ->
            productAdapter.newDataSet(products)
        })
    }


}