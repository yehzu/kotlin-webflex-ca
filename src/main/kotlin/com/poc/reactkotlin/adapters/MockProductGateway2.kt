package com.poc.reactkotlin.adapters

import com.poc.reactkotlin.entities.Product
import com.poc.reactkotlin.ports.data.ProductGateway
import org.springframework.context.annotation.Primary
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import reactor.core.scheduler.Schedulers
import java.math.BigDecimal

@Component
@Primary
class MockProductGateway2 : ProductGateway {
    override fun getProducts(ids: List<String>): Flux<Product> {
        // blocking code should subscribe on other thread pools
        // suggest using bounded elastic
        return Flux.range(1, 6)
            .map { i ->
                Thread.sleep(200)
                Product("$i", "product $i", BigDecimal.valueOf(i * 100L))
            }.subscribeOn(Schedulers.boundedElastic())
    }
}