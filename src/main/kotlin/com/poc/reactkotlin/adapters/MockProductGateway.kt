package com.poc.reactkotlin.adapters

import com.poc.reactkotlin.entities.Product
import com.poc.reactkotlin.ports.data.ProductGateway
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.math.BigDecimal

@Component
class MockProductGateway : ProductGateway {
    override fun getProducts(ids: List<String>): Flux<Product> {
        return Flux.just(
            Product("1", "product 1", BigDecimal.valueOf(100)),
            Product("2", "product 2", BigDecimal.valueOf(200)),
            Product("3", "product 3", BigDecimal.valueOf(300)),
            Product("4", "product 4", BigDecimal.valueOf(400)),
            Product("5", "product 5", BigDecimal.valueOf(500)),
            Product("6", "product 6", BigDecimal.valueOf(600)),
        )
    }
}