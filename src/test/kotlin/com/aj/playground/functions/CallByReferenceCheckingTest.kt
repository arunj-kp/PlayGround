package com.aj.playground.functions

import com.aj.playground.functions.CallByReferenceChecking
import io.kotlintest.shouldBe
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class CallByReferenceCheckingTest {
    private lateinit var callByReferenceChecking: CallByReferenceChecking

    @Before
    fun setUp() {
        callByReferenceChecking = CallByReferenceChecking()
    }

    @Test
    fun testValueOnPassingTrue(){
        callByReferenceChecking.passByBooleanValue(flag = true)

        assertEquals(true, callByReferenceChecking.passByValue.getIsTestValue())
        callByReferenceChecking.passByValue.getIsTestValue() shouldBe true
    }

    @Test
    fun whatHappensWhenValueUpdatedAfterPassingPrimitiveBoolean(){
        callByReferenceChecking.passByBooleanValue(flag = true)
        assertEquals(true, callByReferenceChecking.passByValue.getIsTestValue())

        callByReferenceChecking.testing = false
        assertEquals(true, callByReferenceChecking.passByValue.getIsTestValue())
    }

    @Test
    fun testValueOnPassingReference(){
        callByReferenceChecking.passByReference(true)

        assertEquals(true, callByReferenceChecking.passByReference.getIsTestValue())
    }

    @Test
    fun testValueOnPassingReferenceAfterUpdatingReferenceValue(){
        callByReferenceChecking.passByReference(true)
        assertEquals(true, callByReferenceChecking.passByReference.getIsTestValue())

        callByReferenceChecking.testingObject.localTesting = false
        assertEquals(false, callByReferenceChecking.passByReference.getIsTestValue())
    }
}