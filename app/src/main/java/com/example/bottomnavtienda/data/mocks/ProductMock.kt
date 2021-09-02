package com.example.bottomnavtienda.data.mocks

import com.example.bottomnavtienda.data.models.Product

class ProductMock {
    fun loadProducts(): List<Product> {
        return listOf(
            Product("Producto 1","https://www.latinfoodus.com/wp-content/uploads/2017/11/chocoRamo_mini.jpg", "$5.000", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
            Product("Producto 2","https://pngimg.com/uploads/burger_sandwich/burger_sandwich_PNG96777.png", "$10.000","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
            Product("Producto 3","https://www.latinfoodus.com/wp-content/uploads/2017/11/chocoRamo_mini.jpg", "$5.000","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
            Product("Producto 4","https://pngimg.com/uploads/burger_sandwich/burger_sandwich_PNG96777.png", "$10.000","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"),
        )
    }
}