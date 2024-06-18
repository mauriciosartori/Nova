package com.android.nova.inverviewcamp.binarysearch.tricks
/**
 * Find the square root of an integer X.
 * For example, squareRoot(4) = 2.
 * It is ok to find the integer floor of the square root.
 * So squareRoot(5) or squareRoot(8) can also return 2.
 * squareRoot(9) will return 3.
 *
 * Using Binary Search, you can search for square roots over the integer space.
 * This is pretty fast because it takes O(log(n)) time.
 * Assume that x*x is less than the integer limit.
 */
class BinarySearchTricks2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 7
            println("I'd like to find the root square of $target")
            val result = findClosestRootSquare(target)
            println("And the result is $result")
        }
        fun findClosestRootSquare(target: Int): Int {
            var start = 0
            var end = target / 2
            while (start <= end) {
                val middle = (end + start) / 2
                if (square(middle) > target) {
                    end = middle -1
                } else if (square(middle) < target){
                    if (square(middle + 1) > target) {
                        return middle
                    }
                    start = middle + 1
                } else {
                    return middle
                }
            }
            return -1
        }

        fun square(middle: Int): Int {
            return middle * middle
        }
    }
}