package com.example.plugins

import com.example.service.ProductService
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {

    val productService by inject<ProductService>()

    routing {
        route("/product") {
            get {
                val products = productService.list()
                call.respond(products)
            }
            get("/{id}") {
                call.parameters["id"]?.let {
                    val product = productService.get(it.toInt()) ?: throw NotFoundException("Product not found")
                    call.respond(product)
                } ?: NotFoundException("Product not found")

            }
            post {
                // TODO
                call.respondText("Product created")
            }
        }

    }
}
