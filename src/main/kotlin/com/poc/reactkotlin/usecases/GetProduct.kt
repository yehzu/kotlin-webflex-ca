package com.poc.reactkotlin.usecases

import com.poc.reactkotlin.entities.Product
import com.poc.reactkotlin.ports.data.ProductGateway
import com.poc.reactkotlin.ports.input.GetProductInputBoundary
import com.poc.reactkotlin.ports.output.GetProductOutputBoundary
import com.poc.reactkotlin.ports.output.ProductResponse
import com.poc.reactkotlin.ports.output.ProductUCResponse
import org.springframework.stereotype.Component

@Component
class GetProduct(
    private val presenter: GetProductOutputBoundary,
    private val productGateway: ProductGateway,
) : GetProductInputBoundary {

    override fun get(ids: List<String>) {
        presenter.present(
            productGateway.getProducts(ids)
                .map(this::toResp)
                .collectList()
                .map { ps -> ProductUCResponse(ps) }
        )
    }

    private fun toResp(entity: Product): ProductResponse {
        return ProductResponse(
            entity.id,
            entity.name,
            entity.price,
        )
    }
}