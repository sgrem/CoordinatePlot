package dev.sgrem.scratch_kotlin_lib

fun main() {

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
    // Simple High-Order function for sorting Tasks by priority only
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

    // TaskManager object defined at top level
    TaskManager.addTask("Task #10", InProgress(Priority.LOW))
    TaskManager.addTask("Task #20")
    TaskManager.addTask("Task #13", InProgress(Priority.MEDIUM))
    TaskManager.addTask("Task #13", Completed)

    val TaskManagerTasksSortedByStatus = TaskManager.sortedTasks()
    println("TaskManager Tasks sorted by status:")
    TaskManagerTasksSortedByStatus.forEach {println(it)}
    println()

    val TaskManagerTasksFilteredByCompleted = TaskManager.filterTasks()
    println("TaskManager Tasks filtered by completed:")
    TaskManagerTasksFilteredByCompleted.forEach {println(it)}
    println()
}

// 6. Enum Class
//    NOTE: An enum class can't be defined in a function as a local class.
enum class Priority(){
    LOW,
    MEDIUM,
    HIGH
}

// 7. Sealed Class:
//    NOTE: A sealed class can't be defined in a function as a local class.
sealed class TaskStatus
data class InProgress(val priority: Priority): TaskStatus()
data object Completed : TaskStatus()

// 8. Objects
//    Replaced Task priority and completed with status sealed class TaskStatus
object TaskManager {
    data class Task(
        val title: String,
        var status: TaskStatus
    )
    val taskList: MutableList<Task> = mutableListOf()

    fun addTask(
        title: String,
        status: TaskStatus = InProgress(Priority.HIGH)
    ){
        taskList.add(Task(title, status))
    }

    // Sealed class TaskStatus doesn't have a natural order and
    // needs a custom comparator to sort based on status
    val statusComparator = Comparator<Task> { task1, task2 ->
        when {
            task1.status is Completed && task2.status is Completed -> 0
            task1.status is Completed -> 1
            task2.status is Completed -> -1
            else -> {
                val priority1 = (task1.status as InProgress).priority.ordinal
                val priority2 = (task2.status as InProgress).priority.ordinal
                priority1.compareTo(priority2)
            }
        }
    }

    fun sortedTasks(): List<Task> {
        return taskList.sortedWith(statusComparator)
    }

    fun filterTasks(): List<Task> {
        return taskList.filter { it.status is Completed }
    }
}
