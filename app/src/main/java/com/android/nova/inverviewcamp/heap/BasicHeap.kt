package com.android.nova.inverviewcamp.heap

import java.util.PriorityQueue

/**
 * Find the K smallest numbers in an array.
 * For example,[6,3,6,6,2,2,4] => [2,2,3,4]
 */
class BasicHeap {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kValue = 4
            val inputArray = intArrayOf(6,3,6,6,2,2,4)
            println("Find the K smallest element in an order of n Log k")
            findSmallesKElements(inputArray, kValue)
        }

        fun findSmallesKElements(inputArray: IntArray, kValue: Int) {
            val heap = PriorityQueue<Int>(kValue, Comparator.reverseOrder())

            var i = 0
            for (value in inputArray) {
                if (i > kValue - 1) {
                    if (value < heap.peek()) {
                        heap.remove(heap.peek()) // heap.poll()
                        heap.add(value)
                    }
                } else {
                    heap.add(value)
                }
                i++
            }

            println("At the end of the day the top values are ${heap.toArray().contentToString()}")
        }
    }
}