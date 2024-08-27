package com.android.nova.leetcode.blind75Test.dp
/**
 *
 */
class No8 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun numDecodings(s: String): Int {
            val n = s.length
            val dp = IntArray(n+1){0}
            dp[0] = 1
            for(i in 1..n) {
                val ch = s[i-1]
                if(ch == '0') dp[i] = 0
                val prevCh = if(i > 1) s[i-2] else '0'
                if(ch != '0') dp[i] += dp[i-1]
                if(prevCh != '0' && prevCh <= '1' || prevCh == '2' && ch <= '6') dp[i] += dp[i-2]
            }
            return dp[n]
        }
    }
}