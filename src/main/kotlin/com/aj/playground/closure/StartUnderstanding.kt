package com.aj.playground.closure

import com.aj.playground.functions.functional.unaryOperatin

fun closureFromAForLoop(n: Int): List<Int> {
    val numberList = mutableListOf<Int>()
    for (number in 1..n) {
        val square = unaryOperatin(number) {
            number * number
        }
        numberList.add(square)
    }
    return numberList
}