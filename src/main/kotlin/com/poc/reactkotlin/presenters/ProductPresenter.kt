package com.poc.reactkotlin.presenters

import com.poc.reactkotlin.ports.output.GetProductOutputBoundary
import com.poc.reactkotlin.ports.output.ProductUCResponse
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class ProductPresenter : GetProductOutputBoundary {
    lateinit var model: Mono<ProductUCResponse>

    override fun present(response: Mono<ProductUCResponse>) {
        model = response
    }

    fun getModelView(): Mono<ProductUCResponse> {
        return model
    }
}