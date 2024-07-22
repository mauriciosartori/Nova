package com.android.nova.inverviewcamp.heap
/**
 * Implementing a Heap and use it
 */
class CustomHeapSecondTry {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kValue = 4
            val inputArray = intArrayOf(1,6,3,6,6,2,2,4,9, 1, 19, 0)
            println("Find the K smallest element in an order of n Log k")
            findSmallesKElements(inputArray, kValue)
        }

        fun findSmallesKElements(inputArray: IntArray, kValue: Int) {
            val heap = MyHeap(kValue)
            var i = 0
            for (value in inputArray) {
                if (i > kValue - 1) {
                    if (value < heap.peek()) {
                        heap.poll()
                        heap.add(value)
                    }
                } else {
                    heap.add(value)

                }
                i++
            }

            println("At the end of the day the top values are ${heap.print()}")
            println("And the peak is ${heap.peek()}")
        }
    }

    private class MyHeap(var kValue: Int) {

        val valuesList = ArrayList<Int>(kValue)
        fun peek(): Int {
            return valuesList[0]
        }
        fun poll() {
            // Remove the first element and do a heapify
            val left = leftChild(0)
            val right = rightChild(0)

            if (valuesList[left] >  valuesList[right]) {
                val leftValue = valuesList[left]
                valuesList[0] = leftValue
                val leftLeftIndex = leftChild(left)
                valuesList[left] = valuesList[leftLeftIndex]
                valuesList.removeAt(leftLeftIndex)
            } else {
                // Right value is the biggest
                valuesList[0] = valuesList[right]
                valuesList.removeAt(right)
            }
        }

        fun heapify() {
            var currentIndex = 0
            while (currentIndex < valuesList.size) {
                val leftIndex = leftChild(currentIndex)
                val rightIndex = rightChild(currentIndex)

                if (leftIndex < valuesList.size &&  valuesList[leftIndex] > valuesList[currentIndex]) {
                    swap(leftIndex, currentIndex)
                    currentIndex = leftIndex
                } else if (rightIndex < valuesList.size &&  valuesList[rightIndex] > valuesList[currentIndex]) {
                    swap(rightIndex, currentIndex)
                } else {
                    break
                }

            }
        }
        private fun swap(a: Int, b: Int) {
            val temp = valuesList[a]
            valuesList[a] = valuesList[b]
            valuesList[b] = temp
        }
        fun add(value: Int) {
            if (valuesList.size < 4) {
                valuesList.add(value)
            } else {
                valuesList.add(value)
            }
            heapify()
        }
        private fun leftChild(i: Int): Int {
            return 2 * i +  1
        }

        private fun rightChild(i: Int): Int {
            return 2 * i +  2
        }

        private fun parent(i: Int): Int {
            return (i - 1) / 2
        }
        fun print() {
            println("Values in the list: ${valuesList.joinToString(", ")}")
        }
    }
}