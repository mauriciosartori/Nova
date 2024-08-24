package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = wordBreak("leetcode", arrayListOf("leet","code"))
            println("Response for No4 $result")
        }
        fun wordBreak(s: String, wordDict: List<String>): Boolean {
            val n = s.length
            val dp = BooleanArray(n + 1)
            dp[0] = true

            for (i in 0..n) {
                for (j in 0..i) {
                    if (dp[j] && wordDict.contains(s.substring(j,i))) {
                        dp[i] = true
                        break
                    }
                }
            }
            return dp[n]
        }
    }
}