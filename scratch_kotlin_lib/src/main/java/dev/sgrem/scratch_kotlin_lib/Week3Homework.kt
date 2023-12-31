package dev.sgrem.scratch_kotlin_lib

fun main(){
    println("1. Boolean Comparisons:")
    println("2 + 6 is divisible by 4: ${isDivisibleByFour(2, 6)}")
    println("2 + 7 is divisible by 4: ${isDivisibleByFour(2, 7)}")
    println()

    println("2. Combining Logic Operators:")
    var str = "apple zebra"
    println("String \"$str\" contains both 'a' and 'z': ${str.containsBoth('a', 'z')}")
    str = "apple ebra"
    println("String \"$str\" contains both 'a' and 'z': ${str.containsBoth('a', 'z')}")
    str = "Apple Zebra"
    println("String \"$str\" contains both 'a' and 'z': ${str.containsBoth('a', 'z')}")
    println()

    println("3. If/Else Conditions:")
    var temperature = 0
    println("The temperature is $temperature: ${checkTemperature(temperature)}")
    temperature = 10
    println("The temperature is $temperature: ${checkTemperature(temperature)}")
    temperature = 25
    println("The temperature is $temperature: ${checkTemperature(temperature)}")
    temperature = 26
    println("The temperature is $temperature: ${checkTemperature(temperature)}")
    println()

    println("4. Loops:")
    var number = 3; var limit = 15
    println("Multiples of $number <= $limit:")
    printMultiples(number, limit)
    number = 2; limit = 9
    println("Multiples of $number <= $limit:")
    printMultiples(number, limit)
    println()

    println("5. When Statements:")
    var score = 100
    println("Grade for score $score: ${getGrade(score)}")
    score = 89
    println("Grade for score $score: ${getGrade(score)}")
    score = 79
    println("Grade for score $score: ${getGrade(score)}")
    score = 69
    println("Grade for score $score: ${getGrade(score)}")
    score = 59
    println("Grade for score $score: ${getGrade(score)}")
    score = 101
    println("Grade for score $score: ${getGrade(score)}")
    println()

    println("6. Nullability")
    var myInt: Int? = 5
    println("${myInt ?: 0} * 2 = ${timesTwo(myInt)}")
    myInt = null
    println("${myInt ?: 0} * 2 = ${timesTwo(myInt)}")
    println()

    println("7. (Above and Beyond) Spiral Array:")
    var n = 1
    println("Spiral $n x $n matrix:")
    printListOfLists(generateSpiralArray(n))
    n = 2
    println("Spiral $n x $n matrix:")
    printListOfLists(generateSpiralArray(n))
    n = 3
    println("Spiral $n x $n matrix:")
    printListOfLists(generateSpiralArray(n))
    n = 4
    println("\nSpiral $n x $n matrix:")
    printListOfLists(generateSpiralArray(n))
    n = 5
    println("\nSpiral $n x $n matrix:")
    printListOfLists(generateSpiralArray(n))

}


/*
1. Boolean Comparisons:
- Write a Kotlin function that takes two integer parameters and returns `true` if their sum is divisible by 4, otherwise returns `false`.
*/
fun isDivisibleByFour(num1: Int, num2: Int): Boolean {
    return (num1 + num2) % 4 == 0
}


/*
2. Combining Logic Operators:
- Write a Kotlin function that takes in a string parameter and returns `true` if the string contains both ‘a’ and ‘z’ characters (the check is case-sensitive), otherwise returns `false`.
*/
fun String.containsBoth(a: Char, b: Char): Boolean {
    return this.contains(a) && this.contains(b)
}


/*
3. If/Else Conditions:
- Write a Kotlin function called checkTemperature that takes a temperature in Celsius as a parameter. The function should return a message based on the temperature as follows:
If the temperature is below freezing (0°C or lower), return "It's freezing cold!"
If the temperature is between 0°C and 10°C (inclusive), return "It's chilly."
If the temperature is between 11°C and 25°C (inclusive), return "It's pleasant."
If the temperature is above 25°C, return "It's warm."
*/
fun checkTemperature(temperatureCelsius: Int): String {
    return when {
        temperatureCelsius <= 0 -> "It's freezing cold!"
        temperatureCelsius in 1..10 -> "It's chilly."
        temperatureCelsius in 11..25 -> "It's pleasant."
        else -> "It's warm."
    }
}


/*
4. Loops:
- Write a Kotlin function called printMultiples that takes two integers, number and limit, as parameters. The function should use a loop to print all the multiples of number up to and including limit. Each multiple should be printed on a new line.
In this example, when printMultiples(3, 15) is called, the function should print:
3
6
9
12
15
*/
fun printMultiples(number: Int, limit: Int) {
    for (i in number..limit step number) {
        println(i)
    }
}


/*
5. When Statements:
- Write a Kotlin function called getGrade that takes a student's numeric score as a parameter (an integer between 0 and 100) and returns a letter grade based on the following grading scale:
90-100: "A"
80-89: "B"
70-79: "C"
60-69: "D"
0-59: "F"
*/
fun getGrade(score: Int): String{
    return when(score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        in 0..59 -> "F"
        else -> "Error: Score $score out of bounds (0 - 100)"
    }
}


/*
6. Nullability:
- Write a Kotlin function that takes a nullable integer as input and returns that integer value times 2.  If the integer is null, return 0.  For example an input of 3 returns 6, an input of 5 returns 10, and an input of null returns 0.
 */
fun timesTwo(myInt: Int?): Int = if(myInt != null) myInt * 2 else 0


 /*
7. (Above and Beyond) Spiral Array:
- Write a Kotlin function called generateSpiralArray that takes an integer n as a parameter and generates an n x n matrix in the form of a spiral. The function should return the spiral matrix as a list of lists (a 2D array).
For example, given n = 3, the function should return:
[
[1, 2, 3],
[8, 9, 4],
[7, 6, 5]
]
*/
 fun generateSpiralArray(n: Int): List<List<Int>> {
     // n x n matrix of rows 'Array(n)' and columns 'IntArray(n)'
     val matrix = Array(n) { IntArray(n) }
     var value = 1
     var rowStart = 0
     var rowEnd = n - 1
     var colStart = 0
     var colEnd = n - 1

     // Keep spiralling until all columns and rows are filled
     while (rowStart <= rowEnd && colStart <= colEnd) {

         /*
          * go right and fill the row
          *
          */
         for (i in colStart..colEnd) {
             matrix[rowStart][i] = value++
         }
         // next row up
         rowStart++

         /*
          * then go up and fill the column
          *
          * Note: if rowStart > rowEnd the range will be empty and the for body
          * will not be executed
          *
          */
         for (i in rowStart..rowEnd) {
             matrix[i][colEnd] = value++
         }
         // next column to the left
         colEnd--

         /*
          * then go left and fill the row
          *
          * Note: if colEnd > colStart the range will be empty and the for body
          * will not be executed
          *
          */
         for (i in colEnd downTo colStart) {
             matrix[rowEnd][i] = value++
         }
         // next row down
         rowEnd--

         /*
          * then go down and fill the column
          *
          * Note: if rowEnd > rowStart the range will be empty and the for body
          * will not be executed
          *
          */
         for (i in rowEnd downTo rowStart) {
             matrix[i][colStart] = value++
         }
         // next column to the right
         colStart++
     }

     // return a list of n lists
     return matrix.map { it.toList() }
 }

fun printListOfLists(listOfLists: List<List<Int>>) {
    println(listOfLists)
    println("Prettified:")
    listOfLists.forEach {innerList ->
        println(innerList)
    }
}
