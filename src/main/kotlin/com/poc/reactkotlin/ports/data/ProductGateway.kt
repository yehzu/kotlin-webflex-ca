package com.poc.reactkotlin.ports.data

import com.poc.reactkotlin.entities.Product
import reactor.core.publisher.Flux

interface ProductGateway {

    fun getProducts(ids: List<String>): Flux<Product>
}