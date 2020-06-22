package com.aj.playground.closure

import io.kotlintest.shouldBe
import org.junit.Test

class StartUnderstandingTest{
    @Test
    fun `check closure values is working as expected`(){
        closureFromAForLoop(5) shouldBe listOf(1,4,9,16,25)
    }
}