package com.android.nova.inverviewcamp.heap
/**
 * Implementing a Heap and use it
 */
class CustomHeap {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val kValue = 4
            val inputArray = intArrayOf(6,3,6,6,2,2,4)
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
        }
    }

    private class MyHeap(var kValue: Int) {

        val myArray = IntArray(kValue)
        var elements = 0
        fun peek(): Int {
            return myArray[0]
        }
        fun poll() {
            // Remove element from the peek of the array
            val left = leftChild(0)
            val right = rightChild(0)

            if (myArray[right] >= myArray[left]) {
                swap(right, 0)
                myArray[right] = -1
            } else {
                swap(left, 0)
                myArray[left] = -1
            }
        }
        private fun swap(a: Int, b: Int) {
            val temp = myArray[a]
            myArray[a] = myArray[b]
            myArray[b] = temp
        }
        fun add(value: Int) {
            if (value > myArray[0] && elements > 3) {
                return
            }
            // The right is bigger
            if (myArray[rightChild(0)] > value) {
                myArray[0]= myArray[rightChild(0)]
                myArray[rightChild(0)] = value
            } else {
                // put it on the top
                myArray[0] = value
            }
            elements++
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
            println("La cabra")
            for (element in myArray) {
                print("${element}, ")
            }
            println(" ")
        }
    }
}