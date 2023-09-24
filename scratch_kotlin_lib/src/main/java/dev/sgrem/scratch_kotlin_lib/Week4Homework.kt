package dev.sgrem.scratch_kotlin_lib

fun main(){
    println("Hello world!")
}

// 1. Task Data:
data class Task(
    val title: String,
    var priority: Int,
    var completed: Boolean
)


