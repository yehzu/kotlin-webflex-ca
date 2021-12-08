package com.poc.reactkotlin.ports.output

import reactor.core.publisher.Mono

interface GetProductOutputBoundary {
    fun present(response: Mono<ProductUCResponse>)
}