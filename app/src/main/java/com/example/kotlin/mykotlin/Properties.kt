package com.example.kotlin.mykotlin

// computed properties
class RectangleOne(val width: Int, val height: Int) {
    val area: Int // property type is optional since it can be inferred from the getter's return type
        get() = this.width * this.height
}

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"


fun main() {
    val rectangle = RectangleOne(3, 4)
    println("Width=${rectangle.width}, height=${rectangle.height}, area=${rectangle.area}")
}