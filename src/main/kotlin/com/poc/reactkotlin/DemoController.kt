package com.poc.reactkotlin

import com.poc.reactkotlin.ports.input.GetProductInputBoundary
import com.poc.reactkotlin.ports.output.ProductUCResponse
import com.poc.reactkotlin.presenters.ProductPresenter
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@Component
class DemoController(
    val getProduct: GetProductInputBoundary,
    val presenter: ProductPresenter,
) {

    @GetMapping("/product")
    fun product(): Mono<ProductUCResponse> {
        getProduct.get(listOf("1"))

        return presenter.model
    }
}