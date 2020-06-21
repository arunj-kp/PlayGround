package com.aj.playground.functions.functional

/**
 * Fuctional - A function which accepts another function as argument or returns another function.
 */


fun binaryOperation(x: Int, y: Int, op: (Int, Int) -> Int) = op(x, y)
fun unaryOperatin(x: Int, op: (Int) -> Int) = op(x)
fun sum(x: Int, y: Int) = x + y

fun square(x: Int) = x * x

fun main() {
    binaryOperation(1, 2, ::sum)

    //Now, what is Lambda ?
    // The same can be achieved by an explicit method, add the implementation on the fly
    binaryOperation(2, 3, { x, y -> x + y })

    //If Lambda is last param, it can be written as:
    binaryOperation(2, 3) { x, y -> x + y }

    unaryOperatin(6, ::square) // Similar to the above binary one, passing the method as argument
    unaryOperatin(6) { x -> x * x } // Lambda
    unaryOperatin(6) { it * it } // If it is a single parameter lambda, it is possible to write using `it` (IMO it is confusing)
}