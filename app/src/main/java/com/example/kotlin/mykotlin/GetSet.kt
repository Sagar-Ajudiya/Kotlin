package com.example.kotlin.mykotlin

//getters and setters are optional and are auto-generated if you do not create them in your program.

class MyData {
    var age: Int = 0
    get() = field
    set(value) {
        field = if (value < 18) 18
        else if (value in 18..30) value
        else value - 3
    }
}

fun main() {
    var data1 = MyData()
    println("Get age ${data1.age}")
    data1.age = 35
    println("Set age ${data1.age}")
}