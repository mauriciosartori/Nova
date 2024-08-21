package com.android.nova.leetcode.blind75Test
/**
 *
 */
class No17 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = countBits(5)
            println("The response after the process is ${result.contentToString()}")
        }
        fun countBits(n: Int): IntArray {
            val resultArray = IntArray(n + 1)
            var offset = 1

            for (i in 1..n) {
                if (offset * 2 == i) {
                    offset = i
                }
                resultArray[i] = 1 +  resultArray[i - offset]
            }
            return resultArray

        }
    }
}