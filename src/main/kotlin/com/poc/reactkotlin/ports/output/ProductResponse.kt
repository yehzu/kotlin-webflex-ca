package com.poc.reactkotlin.ports.output

import java.math.BigDecimal

class ProductResponse(
    val id: String,
    val name: String,
    val price: BigDecimal,
) {

}