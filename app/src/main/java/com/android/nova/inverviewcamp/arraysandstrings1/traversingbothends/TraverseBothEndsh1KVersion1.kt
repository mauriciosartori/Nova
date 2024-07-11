package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends

import kotlin.math.abs

/**
 * Given a sorted array in non-decreasing order,
 * return an array of squares of each number,
 * also in non-decreasing order. For example:
 * [-4,-2,-1,0,3,5] -> [0,1,4,9,16,25]
 * How can you do it in O(n) time?
 */
class TraverseBothEndsh1KVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(-4,-2,-1,0,3,5)
            println("The input array is ${inputArray.contentToString()}")
            convertArrayToSquares(inputArray)
        }
        fun convertArrayToSquares(inputArray: IntArray) {
            val auxArray = IntArray(inputArray.size)
            var start = 0
            var end = inputArray.size - 1
            var currentIndex = inputArray.size - 1
            while (start <= end) {
                val left = abs(inputArray[start])
                val right = abs(inputArray[end])
                if (left > right) {
                    auxArray[currentIndex] = left * left
                    start++
                    currentIndex--
                } else {
                    auxArray[currentIndex] = right * right
                    currentIndex--
                    end--
                }
            }

            println("The array result is ${auxArray.contentToString()}")
        }
    }
}