package com.android.nova.inverviewcamp.queue
/**
 * Level: Easy
 * Given an array of integers A, find the sum of each sliding window of size K.
 * For example: if A = [2,3,5,6,2,1]
 *
 * Sliding Window Sums:
 * [2,3,5,6,2,1] => 10
 * [2,3,5,6,2,1] => 14
 * [2,3,5,6,2,1] => 13
 * [2,3,5,6,2,1] => 9
 */
class QueueSlidingWindow {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 3
            val inputArray = intArrayOf(2,3,5,6,2,1)
            println("Finding the different sums on a array on groups of size $target")
            getSums(inputArray, target)
        }
        fun getSums(inputArray: IntArray, target: Int) {
            val myQueue = SlidingWindowsQueue()
            myQueue.display()
            println("Now... getting the sliding windows señores")
            myQueue.getSlidingWindowsSums(inputArray, target)
        }
    }

}

class SlidingWindowsQueue: AuxQueue() {
    override fun getSlidingWindowsSums(inputArray: IntArray, target: Int) {
        for (i in 0..(inputArray.size - target)) {
            getCurrentSum(inputArray, i, target)

        }
    }
    fun getCurrentSum(inputArray: IntArray, mainIndex: Int, target: Int) {
        var auxMainIndex = mainIndex
        for (i in 0.. target - 1 ) {
            myLinkedList.add(inputArray[auxMainIndex])
            auxMainIndex++
        }
        myLinkedList.display()
        var currentSum = 0
        for (i in 0.. target - 1 ) {
            val valueRemoved = myLinkedList.remove()
            if (valueRemoved != null) {
                currentSum += valueRemoved
            }
        }

        print("and the current sum of this is $currentSum")
        println(" ")
    }

}