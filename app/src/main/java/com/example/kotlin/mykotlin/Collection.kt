package com.example.kotlin.mykotlin

fun main() {


    val numbers = listOf(1, 2, 3, 4, 5, 6, 7)
    val words = listOf("apple", "fruits", "banana", "cherry", "apricot")
    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))



    // map
    println(numbers.map { it* 2 })
    println(words.map { it.length })
    println()

    // zip & unzip
    println(numbers zip words)
    println(numberPairs.unzip())
    println()

    // accosiatewith
    println(words.associateWith { it.length })
    println(words.associateBy { it.first() })
    println()

    // flatten
    println(numberSets.flatten())
    println()

    // filter
    println(words.filter { it.length > 5 })
    println()

    // groupby
    println(words.groupBy { it.length })
    println(words.groupBy(keySelector = {it.first()}, valueTransform = {it.uppercase()} ))
    println()

    // slice
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2))
    println(numbers.slice(setOf(3, 5, 0)))
    println()

    // take & drop
    println(numbers.take(3))
    println(numbers.takeLast(3))
    println(numbers.drop(1))
    println(numbers.dropLast(5))
    println()

    println(words.takeWhile { !it.startsWith('f') })
    println(words.takeLastWhile { it != "three" })
    println(words.dropWhile { it.length == 3 })
    println(words.dropLastWhile { it.contains('i') })
    println()

    // chunked
    println(numbers.chunked(3))
    println(numbers.chunked(3) { it.sum() })
    println()

    // windowed
    println(numbers.windowed(3))
    println(numbers.windowed(3, step = 2, partialWindows = true))
    println(numbers.windowed(3, step = 2, partialWindows = false))
    println(numbers.windowed(3) {it.sum() })


}