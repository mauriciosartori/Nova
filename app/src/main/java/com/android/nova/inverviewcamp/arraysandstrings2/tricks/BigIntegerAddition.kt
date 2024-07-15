package com.android.nova.inverviewcamp.arraysandstrings2.tricks
/**
 * 1. (Level: Hard) BigInteger Addition: You are given a number in the form of an array.
 * Each digit in the array represents a digit in the number.
 * For example, 100 -> [1,0,0].
 * Perform addition of 2 such number arrays. For example,
 *
 * [1,1,1,1] + [2,2,3,3] = [3,3,4,4]
 * [9,9] + [1] = [1,0,0]
 */
class BigIntegerAddition {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputUno = intArrayOf(9,9,9)
            val inputDos = intArrayOf(7,7,7)

//            val inputUno = intArrayOf(1,1,1,1)
//            val inputDos = intArrayOf(2,2,3,3)

//            val inputUno = intArrayOf(3,4,2)
//            val inputDos = intArrayOf(1,9)
            println("Sum big numbers, in this case I'll sum ")
            println(inputUno.contentToString())
            println(inputDos.contentToString())
            sumBigNumbers(inputUno, inputDos)
        }

        fun sumBigNumbers(inputUno: IntArray, inputDos: IntArray) {
            var carry = 0
            val largeArray = if (inputUno.size > inputDos.size) inputUno else inputDos
            val smallArray = if (inputUno.size > inputDos.size) inputDos else inputUno
            val smallArrayResized = resizeArray(smallArray, largeArray.size)

            val resultArray = IntArray(largeArray.size + 1)

            for (i in largeArray.size - 1 downTo 0) {
                val sum = largeArray[i] + smallArrayResized[i] + carry
                resultArray[i + 1] = sum % 10
                carry = sum / 10
            }
            println("_____________")

            if (carry > 0) {
                resultArray[0] = carry
            }
            println(resultArray.contentToString())
        }

        fun resizeArray(smallArray: IntArray, optimaSize: Int): IntArray {
            if (smallArray.size == optimaSize) {
                return smallArray
            }
            val resizedArray = IntArray(optimaSize)
            var auxIndex = optimaSize - 1
            for (i in smallArray.size - 1 downTo 0) {
                resizedArray[auxIndex] = smallArray[i]
                auxIndex--
            }
            return resizedArray
        }
    }
}