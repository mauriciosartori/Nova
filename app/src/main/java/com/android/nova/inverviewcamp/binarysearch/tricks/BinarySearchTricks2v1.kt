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
class BinarySearchTricks2v1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = 15
            println("I'd like to find the root square of $target")
            val result = findClosestRootSquare(target)
            println("And the result is $result")
        }

        fun findClosestRootSquare(target: Int): Int {
            var start = 0
            var end = target / 2

            while (start <= end) {
                val middle = (start + end) / 2
                val doNothingUno = square(middle)
                if (square(middle) > target ) {
                    end = middle - 1
                } else if (square(middle) < target ) {
                    val doNothing = square(middle + 1)
                    if (square(middle + 1) > target) {
                        return middle
                    }
                    start = middle + 1
                } else {
                    // This number has an actual square root just return it
                    return middle
                }
            }
            return -1
        }

        fun square(target: Int):Int {
            return target * target
        }
    }
}