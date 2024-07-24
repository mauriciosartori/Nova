package com.android.nova.inverviewcamp.selectionalgorithm

import java.util.Random

/**
 * Level: Hard
 * Find the Kth smallest element in a given array of integers.
 * For example,
 * If A => [5,7,4,6,5,3,3] and K => 3,
 * The result will be 4
 *
 * This is also known as the Kth order statistic of the array
 */
class BaseSelectionAlgorithm {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(5,7,4,6,5,3,3)
            val target = 3
            println("The input array is ${inputArray.joinToString(", ")}")
            findkElement(inputArray, target)
        }

        fun findkElement(inputArray: IntArray, target: Int) {
            val kIndexValue = findkHelper(inputArray, target - 1, 0, inputArray.size - 1)
            println("The k $target value  is $kIndexValue")
        }

        fun findkHelper(inputArray: IntArray, target: Int, startIndex: Int, endIndex: Int): Int {
            val pivotRandom = (startIndex.. endIndex).random()
            val pivotIndex = partitionArray(inputArray, pivotRandom, startIndex, endIndex)

            if (pivotIndex == target) {
                return inputArray[pivotIndex]
            } else if (target < pivotIndex) {
                return findkHelper(inputArray, target, startIndex, pivotIndex - 1)
            } else {
                //return findkHelper(inputArray, target - pivotIndex - 1, pivotIndex + 1, endIndex)
                return findkHelper(inputArray, target, pivotIndex + 1, endIndex)
            }
        }

        fun partitionArray(inputArray: IntArray, pivotIndex: Int, startIndex: Int, endIndex: Int): Int {
            swap(inputArray, pivotIndex, startIndex)
            var less = startIndex
            for (i in (startIndex + 1)..endIndex) {
                if (inputArray[i] <= inputArray[startIndex]) {
                    swap(inputArray, less + 1, i)
                    less++
                }
            }
            swap(inputArray, less, startIndex)
            return less
        }

        fun swap(inputArray: IntArray, a: Int, b: Int) {
            val temp = inputArray[a]
            inputArray[a] = inputArray[b]
            inputArray[b] = temp
        }
    }
}