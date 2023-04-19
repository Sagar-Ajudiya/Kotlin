package com.example.kotlin.mykotlin

interface CoffeeMaker {
    fun makeCoffee()
}

class SimpleCoffeeMaker : CoffeeMaker {
    override fun makeCoffee() {
        println("Making simple coffee...")
    }
}

class CoffeeMachine(private val coffeeMaker: CoffeeMaker) : CoffeeMaker by coffeeMaker {
    fun makeLatte() {
        coffeeMaker.makeCoffee()
    }
}

fun main() {
    val simpleCoffeeMaker = SimpleCoffeeMaker()
    val coffeeMachine = CoffeeMachine(simpleCoffeeMaker)
    coffeeMachine.makeCoffee()
    coffeeMachine.makeLatte()
}