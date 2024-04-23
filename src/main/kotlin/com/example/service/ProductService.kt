package com.example.service

import com.example.data.Product

class ProductService {

    private val products = listOf(Product(1, "Product 1"), Product(2, "Product 2"))

    fun list(): List<Product> {
        return products
    }

    fun get(id: Int): Product? {
        return products.find { it.id == id }
    }
}
