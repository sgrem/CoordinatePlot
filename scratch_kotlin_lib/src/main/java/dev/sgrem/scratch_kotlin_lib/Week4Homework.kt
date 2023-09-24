package dev.sgrem.scratch_kotlin_lib

fun main() {
    println("Hello world!")

    // 1. Task Data:
    data class Task(
        val title: String,
        var priority: Int = 1,
        var completed: Boolean = false
    )

    // 2. Task List
    val taskList: MutableList<Task> = mutableListOf()

    // 3. Add Task:
    fun addTask(taskList: MutableList<Task>,
                title: String,
                priority: Int = 1,
                completed: Boolean = false
                ){
        taskList.add(Task(title, priority, completed))
    }

    addTask(taskList,"Task #10", 3, true)
    addTask(taskList,"Task #20")
    addTask(taskList,"Task #13", 2, true)

    // 4. Sort Tasks:
    fun <T : Comparable<T>> sortedTasks(
        taskList: MutableList<Task>,
        selector: Task.() -> T): List<Task> {
        return taskList.sortedBy { it.selector() }
    }

    val tasksSortedByTitle = sortedTasks(taskList) {title}
    println("Tasks sorted by title:")
    tasksSortedByTitle.forEach {println(it)}
    println()

    val tasksSortedByPriority = sortedTasks(taskList) {priority}
    println("Tasks sorted by priority:")
    tasksSortedByPriority.forEach {println(it)}
    println()

    val tasksSortedByCompleted = sortedTasks(taskList) {completed}
    println("Tasks sorted by completed:")
    tasksSortedByCompleted.forEach {println(it)}
    println()
}

