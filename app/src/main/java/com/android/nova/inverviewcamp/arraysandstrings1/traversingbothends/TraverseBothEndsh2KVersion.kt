package com.android.nova.inverviewcamp.arraysandstrings1.traversingbothends

/**
 * Given an array of integers, find the continuous subarray,
 * which when sorted, results in the entire array being sorted.
 * For example: A = [0,2,3,1,8,6,9], result is the subarray [2,3,1,8,6]
 */
class TraverseBothEndsh2KVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // val inputArray = intArrayOf(0,2,3,1,8,6,9)
            // val inputArray = intArrayOf(1,2,3,6,4,7,4,8,9,10)
            val inputArray = intArrayOf(1, 2, 4, 5, 3, 7, 5, 6, 8)
            println("The input array is ${inputArray.contentToString()}")
            findSubArray(inputArray)
        }

        fun findSubArray(inputArray: IntArray) {
            var dipIndex = -1;
            var bumpIndex = -1;

            // Find the dip
            for (i in inputArray.indices) {
                //println("The condition was ${inputArray[i]} < ${inputArray[i - 1]} ")
                //println("The i value is $i")
                if (i > 0 && inputArray[i] < inputArray[i - 1]) {
                    println("yes")
                    dipIndex = i - 1
                    break
                }
            }

            // Find the bump
            for (i in inputArray.size - 1 downTo 1 ) {
                // println("The condition was ${inputArray[i]} < ${inputArray[i - 1]} ")
                if (inputArray[i] < inputArray[i - 1]) {
                   // println("yes")
                    bumpIndex = i
                    break
                }
            }

            for (i in 0..dipIndex){
                println("The i value is $i ")
                println("The condition was ${inputArray[i]} > ${inputArray[dipIndex + 1]} ")
                if (inputArray[i] > inputArray[dipIndex + 1]) {
                     println("yes")
                    dipIndex = i
                    break
                }
            }
            println("The indexes are dip index $dipIndex and bump index $bumpIndex")
            println("The array that needs to be sorted is ${inputArray.sliceArray(dipIndex .. bumpIndex).contentToString()}")
        }

    }
}