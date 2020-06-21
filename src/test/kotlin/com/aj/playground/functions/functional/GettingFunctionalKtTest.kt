package com.aj.playground.functions.functional

import io.kotlintest.shouldBe
import org.junit.Test

class GettingFunctionalKtTest {
    @Test
    fun `passing sum function and evaluating the result`() {
        binaryOperation(1, 100, ::sum) shouldBe 101
    }

    @Test
    fun `use lambda and evaluate the result`() {
        binaryOperation(1, 100) { x, y -> x + y } shouldBe 101
    }

    @Test
    fun `evaluate single param lambdas`(){
        unaryOperatin(6, ::square) shouldBe 36 // Similar to the above binary one, passing the method as argument
        unaryOperatin(6) { x -> x * x } shouldBe 36 // Lambda
        unaryOperatin(6) { it * it } shouldBe  36 // If it is a single parameter lambda, it is possible to write using `it` (IMO it is confusing)
    }
}