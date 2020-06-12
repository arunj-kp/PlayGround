package com.aj.playground

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
        assertEquals(true, callByReferenceChecking.passByReference.testObject.isTesting())

        callByReferenceChecking.testingObject.localTesting = false
        assertEquals(false, callByReferenceChecking.passByReference.getIsTestValue())
    }
}