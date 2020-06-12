package com.aj.playground

class CallByReferenceChecking {
    internal var testing = false
    internal lateinit var passByValue: PassByValue
    internal lateinit var passByReference: PassByReference

    internal val testingObject = TestingImpl()

    fun passByBooleanValue(flag: Boolean) {
        testing = flag
        passByValue = PassByValue(testing)
    }

    fun passByReference(flag: Boolean) {
        testingObject.localTesting = flag
        passByReference = PassByReference(testingObject)
    }
}

internal class PassByValue(val isTest: Boolean) {
    fun getIsTestValue(): Boolean {
        return isTest
    }
}

internal class PassByReference(val testObject: Testing) {
    fun getIsTestValue(): Boolean {
        return testObject.isTesting()
    }
}

interface Testing {
    fun isTesting(): Boolean
}

internal class TestingImpl : Testing {
    internal var localTesting = false

    override fun isTesting(): Boolean {
        return localTesting
    }
}