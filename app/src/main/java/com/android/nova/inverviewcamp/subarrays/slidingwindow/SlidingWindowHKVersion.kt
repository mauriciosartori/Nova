package com.android.nova.inverviewcamp.subarrays.slidingwindow

/**
 * Given a String, find the longest substring with unique characters.
 * For example: "whatwhywhere" --> "atwhy"
 */
class SlidingWindowHKVersion {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            val inputString = "whatwhywhere"
            println("The input array is $inputString")
            findLongestString(inputString)
        }
        fun findLongestString(inputString: String) {
            val sb = StringBuilder()
            var startI = 0
            var endI = 0
            val charMap = mutableMapOf<Char, Int>()
            charMap[inputString[0]] = 1
            var largestWord = 0
            var result = Pair(0,0)

            while (endI < inputString.length -1) {
                endI++
                val currentChar = inputString[endI]
                // check if the current char is in the map
                if (charMap.containsKey(currentChar)) {
                    // Update the start index, put it ahead of the prev char
                    startI = charMap.getOrDefault(currentChar, -1) + 1
                }
                // Add char to map at index end
                charMap[currentChar] = endI
                // Check is the new window is the largest
                if (endI - startI > largestWord) {
                    result = Pair(startI, endI)
                    largestWord = endI - startI
                }
            }
            println("The result is the following array ${inputString.substring(result.first..result.second)}")
            println("The value of the start is ${result.first} and the value of the end is ${result.second}")
        }
    }
}