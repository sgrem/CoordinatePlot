package dev.sgrem.scratch_kotlin_lib

fun main() {
    println("Hello world!")

    // 1. Task Data:
    data class Task(
        val title: String,
        var priority: Int,
        var completed: Boolean
    )

    // 2. Task List
    val taskList: MutableList<Task> = mutableListOf()

    // 3. Add Task:
    fun addTask(title: String, priority: Int, completed: Boolean){
        taskList.add(Task(title, priority, completed))
    }
}

