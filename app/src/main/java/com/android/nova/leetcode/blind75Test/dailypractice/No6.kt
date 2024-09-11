package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No6 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = getWrongAnswers(3, "ABA")
            println("The result for No6 is $result")
        }
        fun getWrongAnswers(N: Int, C: String): String {
            val stringResult = StringBuilder(N)
            for (index in 0 until C.length) {
                if (C[index] == 'A') {
                    stringResult.append('B')
                } else {
                    stringResult.append('A')
                }
            }
            return stringResult.toString()
        }
    }
}