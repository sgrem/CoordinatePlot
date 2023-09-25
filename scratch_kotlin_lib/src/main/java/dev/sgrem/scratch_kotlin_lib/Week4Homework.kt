package dev.sgrem.scratch_kotlin_lib

fun main() {
    println("Hello world!")

    // 1. Task Data:
    data class Task(
        val title: String,
        // var priority: Int = 1,
        var priority: Priority = Priority.HIGH,
        var completed: Boolean = false
    )

    // 2. Task List
    val taskList: MutableList<Task> = mutableListOf()

    // 3. Add Task:
    fun addTask(taskList: MutableList<Task>,
                title: String,
                // priority: Int = 1,
                priority: Priority = Priority.HIGH,
                completed: Boolean = false
                ){
        taskList.add(Task(title, priority, completed))
    }

    addTask(taskList,"Task #10", Priority.LOW, true)
    addTask(taskList,"Task #20")
    addTask(taskList,"Task #13", Priority.MEDIUM, true)

    // 4. Sort Tasks:
    // Simple High-Order function for sorting Tasks by priority
    fun sortedTasksHighOrder(
        taskList: MutableList<Task>,
        selector: (Task) -> Priority): List<Task> {
        return taskList.sortedBy {selector(it)}
    }
    val tasksSortedByTitleHighOrder = sortedTasksHighOrder(taskList) {it.priority}
    println("Tasks sorted by priority High Order:")
    tasksSortedByTitleHighOrder.forEach {println(it)}
    println()

    /*
     *  sortedTasks is a generic function for any type T that implements
     *  the Comparable<T> interface. The selector parameter is a function
     *  literal with receiver. These are lambda expressions that have a
     *  receiver type, allowing you to call methods and access properties of
     *  the receiver within the lambda.
     */
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

    // 5. Filter Tasks:
    fun filterTasks(
        taskList: MutableList<Task>,
        selector: Task.() -> Boolean
    ): List<Task>{
        return taskList.filter { it.selector() }
    }

    val tasksFilteredByCompleted = filterTasks(taskList) {completed}
    println("Tasks filtered by completed:")
    tasksFilteredByCompleted.forEach {println(it)}
    println()

}

// 6. Enum Class
//    NOTE: An enum class can't be defined as a local class.
enum class Priority(){
    LOW,
    MEDIUM,
    HIGH
}

// 7. Sealed Class:
// sealed class
