package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No11 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
//            // Test case 1
//            val N1 = 5
//            val R1 = arrayOf(2, 5, 3, 6, 5)
//            val result1 = getMinimumDeflatedDiscCount(N1, R1)
//            println("Result for N=$N1, R=${R1.joinToString(", ")}: El resultado es $result1")
            var  andas = "001"
            var andasEntero= andas.toInt()
            println("Andas de mono ebteri  $andasEntero")

            // Test case 2
            val N2 = 4
            val R2 = arrayOf(6, 5, 4, 3)
            val result2 = getMinimumDeflatedDiscCount(N2, R2)
            println("Result for N=$N2, R=${R2.joinToString(", ")}: El resultado es $result2")
        }
        fun getMinimumDeflatedDiscCount(N: Int, R: Array<Int>): Int {
            val discArray = R
            var maxItchesCounter = R[N - 1]
            var modifiedDisc = 0
            for (i in (N - 2) downTo 0) {
                if (discArray[i] >= maxItchesCounter) {
                    maxItchesCounter = maxItchesCounter - 1
                    modifiedDisc++
                } else {
                    maxItchesCounter = discArray[i]
                }
            }
            return modifiedDisc
        }
    }
}