package com.poc.reactkotlin.ports.output

import reactor.core.publisher.Flux

class ProductUCResponse(
    val products: List<ProductResponse>
){

}