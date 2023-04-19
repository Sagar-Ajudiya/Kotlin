package com.example.kotlin.mykotlin

class Lamp {

    private var isOn = false

    fun turnOn() {
        isOn = true
    }

    fun turnOff() {
        isOn = false
    }

    fun displayStatus() {
        if (isOn) {
            println("Light is On")
        } else {
            println("Light is Off")
        }
    }

}

// primary constructor is part of class header

// primary can't contain print
// sec contain print

// init is called with primary constructor
// all init is invoked
// sec constructor is called

// default parameter is only used with primary constructor

open class Person(val _firstName: String = "Default", var _age: Int = 0) {
    val firstName = _firstName
    val age = _age

    init {
        println("First Name: ${firstName}")
        println("Age: ${age}")
    }
}

// no primary constructor, but two secondary constructor
open class Log {
    var data = ""
    var noData = 0

    constructor(_data: String) {
        var data = _data
        println("Data is ${data}")
    }

    constructor(_data: String, _noData: Int) {
        var data = _data
        var noData = _noData
        println("Data is ${data}, No.Data is ${noData}")
    }

}

class AuthLog: Log {
    constructor(_data: String): this("From AuthLog -> $_data", 10) {
    }

    constructor(_data: String, _numberOfData: Int): super(_data, _numberOfData) {
    }
}

// var inside constructor called property, without var only parameters
// with var we used inside object as well
class User(name: String, var lastName: String, var age: Int) {
    var name: String

    init {
        println("init is invoked")
        if (name.lowercase().startsWith("a")) {
            this.name = name
        } else {
            this.name = "Invalid"
        }
    }

    // secondary constructor doesn't provide properties
    constructor(name: String) : this(name, "LastName",0)

    constructor(name: String, lastName: String) : this(name, lastName, 0) {
        println("This is name and lastName constructor")
    }

}

fun main() {

    var lamp = Lamp()
    lamp.turnOn()
    lamp.displayStatus()

    var person1 = Person("Sagar", 20)
    var person2 = Person()

    var log1 = Log("New log")
    var log2 = Log("New data log", 100)

    var authLog1 = AuthLog("authLog data")
    var authLog2 = AuthLog("authLog data new", 1000)

    var user1 = User("Sagar", "Ajudiya", 20)
    println(user1.name)
    println(user1.lastName)
    println(user1.age)

    var user2 = User("Amar")
    println(user2.name)
    println(user2.lastName)
    println(user2.age)

    var user3 = User("Sagar", "Ajudiya", 20) // if I used user3 = user1 then true
    println(user3 == user1)
    println(user3 === user1)

}