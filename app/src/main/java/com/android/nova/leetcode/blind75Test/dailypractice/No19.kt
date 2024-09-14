package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No19 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val A: Long = 75
            val B: Long = 300

            // Create an instance of No19
            val instance = No19()

            // Call the function with the test inputs and print the result
            val result = instance.getUniformIntegerCountInInterval(A, B)
            println("The count of uniform integers between $A and $B is: $result")
        }
    }

    // Write any import statements here

    fun getUniformIntegerCountInInterval(A: Long, B: Long): Int {
        fun getRoundedNumber(number: Long, moveNext: Boolean): Long {
            val numString = number.toString()
            var digitToSpread = numString[0] - '0'
            val numSb = StringBuilder()
            var numSize = numString.length

            if (moveNext) {
                digitToSpread = digitToSpread.toInt() + 1
            }
            if (digitToSpread > 9) {
                numSize++
                digitToSpread = 1
            }

            for (i in 0 until numSize) {
                numSb.append(digitToSpread)
            }
            return numSb.toString().toLong()
        }
        var start = getRoundedNumber(A, false)
        if (start < A) {
            start = getRoundedNumber(A, true)
        }
        val end = B
        var count = 0
        while (start <= end) {
            var currentNumber = getRoundedNumber(start, true)
            start = currentNumber
            count++
        }


        return count
    }

}