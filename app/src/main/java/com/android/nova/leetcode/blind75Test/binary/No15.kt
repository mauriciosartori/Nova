package com.android.nova.leetcode.blind75Test.binary
/**
 *
 */
class No15 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = getSum(2,3)
            println("The result is $result")

        }
        fun getSum(a: Int, b: Int): Int {
            var a2 = a
            var b2 = b
            while (b2 != 0) {
                val tmp = (a2 and b2) shl 1
                a2 = a2 xor b2
                b2 = tmp
            }
            return a2
        }
    }
}