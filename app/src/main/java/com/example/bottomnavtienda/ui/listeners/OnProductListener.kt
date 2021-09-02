package com.example.bottomnavtienda.ui.listeners

import com.example.bottomnavtienda.data.models.Product

interface OnProductListener {
    fun onClick(product: Product)
}