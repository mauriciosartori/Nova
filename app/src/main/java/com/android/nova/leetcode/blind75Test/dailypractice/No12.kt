package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No12 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Test case with A = 75, B = 300
            val A = 75L
            val B = 300L
            val result = getUniformIntegerCountInInterval(A, B)
            println("Result for No12 A=$A, B=$B: $result")
        }
        // Write any import statements here

        fun getUniformIntegerCountInInterval(A: Long, B: Long): Int {
            if (A < 10 && B < 10) {
                return (B - A).toInt()
            }

            if (A == B) {
                return 1
            }

            val bString = B.toString()
            val aInt = A.toInt()
            val bInt = B.toInt()

            var sb = StringBuffer()
            for (i in 1 .. bString.length) {
                sb.append(bString[0] + 1)
            }
            var start = sb.toString().toInt()


            var counter = 0
            var currentNumber = start
            var currentDigit = sb[0].toString().toInt()

            while (currentNumber > aInt) {

                if (currentNumber > bInt) {
                    var sb2 = StringBuffer()
                    for (i in 1 .. bString.length) {
                        sb2.append(currentDigit - 1)
                    }
                    currentNumber = sb2.toString().toInt()
                    currentDigit = currentDigit - 1
                    continue
                }
                var sb3 = StringBuffer()
                var lenghtNumber = currentNumber.toString().length
                if (currentDigit == 0) {
                    currentDigit = 9
                    lenghtNumber = lenghtNumber - 1
                }

                for (i in 0 until lenghtNumber) {
                    sb3.append(currentDigit)
                }
                println(currentNumber)
                currentNumber = sb3.toString().toInt()
                currentDigit = currentDigit - 1
                counter++
            }

            return counter - 1
        }
    }
}