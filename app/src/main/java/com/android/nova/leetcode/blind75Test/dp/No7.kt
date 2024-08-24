package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No7 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = numDecodings("226")
            println("The result for No7 is $result")
        }
        fun numDecodings(s: String): Int {
            val dp = IntArray(s.length)
            dp[0] = 1
            var maxCombinations = 0
            for (i in 1..<s.length) {
                val siToInt = s[i].toString().toInt()
                if (siToInt > 0) {
                    println(siToInt)
                    maxCombinations++
                }
                for (j in i - 1 downTo 0) {
                    val sum = (s[j].toString()+s[i].toString()).toInt()

                    if ((sum) <= 26) {
                        println(sum)
                        maxCombinations++
                    }
                }
            }
            return maxCombinations
        }
    }
}