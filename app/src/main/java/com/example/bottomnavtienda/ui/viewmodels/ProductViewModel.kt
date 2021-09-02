package com.example.bottomnavtienda.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnavtienda.data.models.Product
import com.example.bottomnavtienda.data.repositories.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(private val repo: ProductRepository):ViewModel() {
    private var _products:MutableLiveData<List<Product>> = MutableLiveData()
    val product: LiveData<List<Product>> get() = _products
    private var _selected: MutableLiveData<Product> = MutableLiveData()
    val selected:LiveData<Product> get()= _selected

    fun loadProducts(){
        viewModelScope.launch {
            _products.postValue(repo.loadProducts())
        }
    }
    fun selectedProduct(product:Product){
        _selected.postValue(product)
    }

}