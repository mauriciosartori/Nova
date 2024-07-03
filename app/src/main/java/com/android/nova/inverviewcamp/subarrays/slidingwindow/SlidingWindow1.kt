package com.android.nova.inverviewcamp.subarrays.slidingwindow

/**
 * Given an array of positive integers, find the contiguous subarray that sums to a given number X.
 * For example, input = [1,2,3,5,2] and X=8, Result = [3,5]
 */
class SlidingWindow1 {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,5,2, 19)
            val target = 21
            println("The input array looking to sum $target is ${inputArray.contentToString()}")
            findTargetSum(inputArray, target)
        }

        fun findTargetSum(inputArray: IntArray, target: Int){
            var start = 0
            var end = 0
            var currentSum = inputArray[0]

            while (start < inputArray.size) {
                when{
                   start > end -> {
                       end = start
                       currentSum = inputArray[0]
                   }
                    currentSum < target -> {
                        if (end == inputArray.size -1){
                            break
                        }
                        end++
                        currentSum += inputArray[end]
                    }
                    currentSum > target -> {
                        currentSum -= inputArray[start]
                        start++
                    }
                    else -> {
                        println("The array result is ${inputArray.sliceArray(start..end).contentToString()}")
                    }
                }
            }
            println("The sum was not possible here")
        }
    }
}