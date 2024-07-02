package com.android.nova.inverviewcamp.queue
/**
 * Level: Hard
 * Implement a Queue with O(1) lookup of the Maximum element
 */
class QueueWithMax {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // Example -> 3 -> 2 -> 4 -> 1
            println("Find the max on a Queue")
            //findTheMax(intArrayOf(3,2,4,1))
            findTheMax(intArrayOf(1,4,2,3))
        }

        fun findTheMax(inputArray: IntArray) {
            val tempQueue = TempQueue()
            val maxtTempQueue = TempQueue()

            // var maxValue = 0
            for (i in inputArray.indices) {
                val currentValue = inputArray[i]
                tempQueue.add(currentValue)

                if (maxtTempQueue.peak() < currentValue) {
                    maxtTempQueue.remove()
                    maxtTempQueue.add(currentValue)
                }

                if (maxtTempQueue.peak() > currentValue) {
                    maxtTempQueue.add(currentValue)
                }
            }
            println("At the end of the day the max value is ${maxtTempQueue.peak()} creo...")
            maxtTempQueue.display()
        }
    }
}
private class TempQueue: AuxQueue(){
    override fun getSlidingWindowsSums(inputArray: IntArray, target: Int) {
        TODO("Not yet implemented")
    }
}