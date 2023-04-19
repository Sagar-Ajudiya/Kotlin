package com.example.kotlin.mykotlin

open class PersonData(open val name: String)

data class Student(val id: Int, val grade: Int, override val name: String) : PersonData(name)

data class Teacher(val subject: String, override val name: String) : PersonData(name)

fun main() {
    val student = Student(1, 9, "John")
    val teacher = Teacher("Math", "Alice")

    println("Student name: ${student.name}, id: ${student.id}, grade: ${student.grade}")
    println("Teacher name: ${teacher.name}, subject: ${teacher.subject}")
}

// data class can't be open, sealed, abstract or inner
// atleast one parameter in constructor with var/val