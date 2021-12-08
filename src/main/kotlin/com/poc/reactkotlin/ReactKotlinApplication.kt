package com.poc.reactkotlin

import com.poc.reactkotlin.adapters.MockProductGateway
import com.poc.reactkotlin.ports.data.ProductGateway
import com.poc.reactkotlin.ports.input.GetProductInputBoundary
import com.poc.reactkotlin.ports.output.GetProductOutputBoundary
import com.poc.reactkotlin.presenters.ProductPresenter
import com.poc.reactkotlin.usecases.GetProduct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class ReactKotlinApplication

fun main(args: Array<String>) {
    runApplication<ReactKotlinApplication>(*args)
}

@Bean
fun getProductGateway(): ProductGateway {
    return MockProductGateway()
}

@Bean
fun getProductOutputBoundary(): GetProductOutputBoundary {
    return ProductPresenter()
}

@Bean
fun getProductInputBoundary(
    productOutputBoundary: GetProductOutputBoundary,
    productGateway: ProductGateway,
): GetProductInputBoundary {
    return GetProduct(productOutputBoundary, productGateway)
}
