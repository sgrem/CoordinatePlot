package dev.sgrem.scratch_kotlin_lib

fun main(){
    println("1. Boolean Comparisons:")
    println("2 + 6 is divisible by 4: ${isDivisibleByFour(2, 6)}")
    println("2 + 7 is divisible by 4: ${isDivisibleByFour(2, 7)}")
    println()

    print("2. Combining Logic Operators:")
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

/*
3. If/Else Conditions:
- Write a Kotlin function called checkTemperature that takes a temperature in Celsius as a parameter. The function should return a message based on the temperature as follows:
If the temperature is below freezing (0°C or lower), return "It's freezing cold!"
If the temperature is between 0°C and 10°C (inclusive), return "It's chilly."
If the temperature is between 11°C and 25°C (inclusive), return "It's pleasant."
If the temperature is above 25°C, return "It's warm."
4. Loops:
- Write a Kotlin function called printMultiples that takes two integers, number and limit, as parameters. The function should use a loop to print all the multiples of number up to and including limit. Each multiple should be printed on a new line.
In this example, when printMultiples(3, 15) is called, the function should print:
3
6
9
12
15


5. When Statements:
- Write a Kotlin function called getGrade that takes a student's numeric score as a parameter (an integer between 0 and 100) and returns a letter grade based on the following grading scale:
90-100: "A"
80-89: "B"
70-79: "C"
60-69: "D"
0-59: "F"
6. Nullability:
- Write a Kotlin function that takes a nullable integer as input and returns that integer value times 2.  If the integer is null, return 0.  For example an input of 3 returns 6, an input of 5 returns 10, and an input of null returns 0.

7. (Above and Beyond) Spiral Array:
- Write a Kotlin function called generateSpiralArray that takes an integer n as a parameter and generates an n x n matrix in the form of a spiral. The function should return the spiral matrix as a list of lists (a 2D array).
For example, given n = 3, the function should return:
[
[1, 2, 3],
[8, 9, 4],
[7, 6, 5]
]

*/
