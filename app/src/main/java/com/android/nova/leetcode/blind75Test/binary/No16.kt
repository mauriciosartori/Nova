package com.android.nova.leetcode.blind75Test.binary
/**
 *
 */
class No16 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = countBits(2)
            println("El resultado es ${result.contentToString()}")
        }

        fun countBits(target: Int): IntArray {
            val resultArray = IntArray(target + 1)
            var currentValue = 0
            var index = 0
            while (currentValue <= target) {
                var temp = currentValue

                var counter = 0
                while (temp !=0) {
                    val tempResult = temp and 1
                    if (tempResult == 1) {
                        counter++
                    }
                    temp = temp shr 1
                }

                resultArray[index++] =  counter
                currentValue = currentValue + 1
            }
            return resultArray
        }
    }
}