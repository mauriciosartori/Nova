package com.android.nova.inverviewcamp.arraysandstrings2.tricks
/**
 * (Level: Medium) Find the longest palindromic substring in a string. For example:
 *
 * "abcababadef" => "ababa"
 * "ffabbahh" => "abba"
 */
class LongestPalindromic {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //val inputString = "abcababadef" // Odd case
            val inputString = "ffabbahh" // Even case
            println("The string to analize is $inputString")
            findPalindrom(inputString.toCharArray())
        }

        fun findPalindrom(charArray: CharArray) {
            var longestPalindrom = 0
            var resul: Pair<Int, Int> = Pair(0, 0)
            // Odd case
            for (i in charArray.indices) {
                var offset = 0

                while (isValidIndex(charArray, i + 1 + offset)
                    && isValidIndex(charArray, i - 1 - offset)
                    && charArray[i + 1 + offset] == charArray[i - 1 - offset]) {
                    offset++
                }
                val palindromSize = offset * 2 + 1

                if (palindromSize > longestPalindrom) {
                    longestPalindrom = palindromSize
                    resul = Pair(i - offset, i + offset)
                }
            }

            // Even case
            for (i in charArray.indices) {
                var offset = 0

                while (isValidIndex(charArray, i + 1 + offset)
                    && isValidIndex(charArray, i - offset)
                    && charArray[i + 1 + offset] == charArray[i - offset]) {
                    offset++
                }
                val palindromSize = offset * 2

                if (palindromSize > longestPalindrom) {
                    longestPalindrom = palindromSize
                    resul = Pair(i - offset + 1, i + offset)
                }
            }

            println("The result is on one side ${resul.first} and on the second is ${resul.second}")
            println("In other words the result is ${String(charArray).substring(resul.first..resul.second)}")
        }

        fun isValidIndex(charArray: CharArray, index: Int): Boolean {
            return index >= 0 && index < charArray.size
        }
    }
}