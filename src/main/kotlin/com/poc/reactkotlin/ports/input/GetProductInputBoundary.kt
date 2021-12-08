package com.poc.reactkotlin.ports.input

interface GetProductInputBoundary {
    fun get(ids: List<String>)
}