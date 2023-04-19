package com.example.kotlin.mykotlin

@JvmInline
value class Email(val value: String) {
    val name: String get() = value
}


// in constructor only one parameter with va
// no backing field, only backing properties
// all member with val only