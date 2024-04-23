package com.example.plugins

import com.example.data.Product
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/product") {
            val products = listOf(Product(1, "Product 1"), Product(2, "Product 2"))
            call.respond(products)
        }
        get("/product/{id}") {
            call.parameters["id"]?.let {
                val product = Product(it.toInt(), "Product $it")
                call.respond(product)
            } ?: call.respondText("Product not found")

        }
    }
}
