package com.android.nova.inverviewcamp.subarrays.slidingwindow

/**
 * Given an array of positive integers, find the contiguous subarray that sums to a given number X.
 * For example, input = [1,2,3,5,2] and X=8, Result = [3,5]
 */
class SlidingWindow {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = intArrayOf(1,2,3,5,2)
            val target = 8
            println("The input array is ${inputArray.contentToString()}")
            findTargetSum(inputArray, target)
        }

        fun findTargetSum(inputArray: IntArray, target: Int){
            var startIndex = 0
            var endIndex = 0
            var currentSum = inputArray[0]
            while(startIndex <inputArray.size) {
                when{
                    // For this case start went beyond the end and that can't be possible
                    // Therefore, we restart the index from here
                    startIndex > endIndex -> {
                        endIndex = startIndex
                        currentSum = inputArray[startIndex]
                    }
                    currentSum < target -> {
                        // Need to check is index can be increased, if not just break the loop
                        // And mention that this is not possible
                        if (endIndex == inputArray.size -1){
                            break
                        }
                        endIndex++
                        currentSum = currentSum + inputArray[endIndex]
                    }
                    currentSum > target -> {
                        currentSum = currentSum - inputArray[startIndex]
                        startIndex++
                    } else ->{
                        println("The current sum happens here ${inputArray.sliceArray(startIndex..endIndex).contentToString()} from the index $startIndex to $endIndex")
                        break
                    }
                }
            }
        }
    }
}