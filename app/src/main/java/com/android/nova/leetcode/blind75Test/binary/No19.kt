package com.android.nova.leetcode.blind75Test.binary
/**
 *
 */
class No19 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = reverseBits(43261596)
            println("The result is actually  $result")
        }
        fun reverseBits(n:Int):Int {
            var temp = n
            var result = 0
            for (i in 0 until 32) {
                val bit = temp shr i and 1
                result = result or (bit shl (31 - i))
            }
            return result
        }
    }
}