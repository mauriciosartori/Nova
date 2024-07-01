package com.android.nova.inverviewcamp.queue
/**
 * Level:Easy
 * Implement a Queue using an array
 */
class QueueWithArrays {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputArray = IntArray(9)
            println("Implement a queue using an array")
            queueDemo()
        }
        fun queueDemo() {
            println("Adding the following values -> 5,2,4,4,6")
            println("So the result is")
            val myQueue =  Queue(IntArray(9))
            myQueue.add(5)
            myQueue.add(2)
            myQueue.add(4)
            myQueue.add(4)
            myQueue.add(6)
            myQueue.print()
            println("Now I am doing 2 removals and the result is")
            myQueue.remove()
            myQueue.remove()
            myQueue.print()
        }
    }
    private class Queue(val inputArray: IntArray) {
        var start = 0
        var end = 0
        var size = 0

        fun add(value: Int) {
            inputArray[end] = value

            // Increase end to the next one
            end = (end + 1) % inputArray.size
            size++
        }

        fun remove() {
            val valToRemove = inputArray[start]

            // Increase the start to the next one
            start = (start + 1) % inputArray.size
            // I am missing updating the lenght for the love of good
            size--
        }

        fun print() {
            for (i in start..end - 1 ) {
                print("${inputArray[i]}, ")
            }
            println(" ")
        }
    }
}