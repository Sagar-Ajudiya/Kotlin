package com.example.kotlin.mykotlin

class Example // Implicitly inherits from Any

// by default final, to inherit mark with open
open class MyClass // Class is open for inheritance

open class Shape {

    open val countVertex = 0

    open fun draw() {
        println("Shape is Drawing")
    }
    fun fill() {
        println("Fill method is called")
    }
    open fun color() {
        println("Color is filling")
    }
}

// also make override method final in subclass

class Circle() : Shape() {

    override var countVertex = 1

    override fun draw() {
        println("Circle is drawing")
    }
     final override fun color() {
        super.color()
         println("This is inside circle color")
    }

}

// first base class property is initialized after that child class property is initialized
open class Base(val name: String) {

    init { println("Initializing a base class") }

    open val size: Int =
        name.length.also { println("Initializing size in the base class: $it") }
}

class Derived(
    name: String,
    val lastName: String,
) : Base(name.replaceFirstChar { it.uppercase() }.also { println("Argument for the base class: $it") }) {

    init { println("Initializing a derived class") }

    override val size: Int =
        (super.size + lastName.length).also { println("Initializing size in the derived class: $it") }
}


open class Rectangle {
    open fun draw() { println("Drawing a rectangle ---1") }
    val borderColor: String get() = "black"
}

class FilledRectangle: Rectangle() {
    override fun draw() {
        val filler = Filler()
        filler.drawAndFill()
    }

    inner class Filler {
        fun fill() { println("Filling ----2") }
        fun drawAndFill() {
            super@FilledRectangle.draw() // Calls Rectangle's implementation of draw()
            fill()
            println("Drawn a filled rectangle with color ${super@FilledRectangle.borderColor} ----3") // Uses Rectangle's implementation of borderColor's get()
        }
    }
}

fun main() {
    println("Constructing the derived class(\"hello\", \"world\")")
    Derived("hello", "world")

    val circle = Circle()
    circle.countVertex
    circle.draw()
    circle.color()
    circle.fill()

    val fr = FilledRectangle()
    fr.draw()

}