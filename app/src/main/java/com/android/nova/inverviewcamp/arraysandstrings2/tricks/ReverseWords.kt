package com.android.nova.inverviewcamp.arraysandstrings2.tricks
/**
 * (Level: Easy) Reverse the words in a sentence. For example,
 * "what is your name" => "name your is what"
 */
class ReverseWords {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputString = "what is your name"
            println("We are reversing the following string $inputString")
            reverseString(inputString)
        }

        fun reverseString(inputString: String) {
            val inputArray = inputString.toCharArray()
            var start = 0
            var end = inputArray.size - 1
            while (start < end) {
                swap(inputArray, start, end)
                start++
                end--
            }

            var startIndex = 0
            for (i in inputArray.indices) {
                if (inputArray[i] == ' ' || i == inputArray.size - 3) {
                    swapWord(inputArray, startIndex, i - 1)
                    startIndex = i + 1
                }
            }

            val result = String(inputArray)
            println("The result is ${result}")
        }

        fun swapWord(inputArray: CharArray, startIndex: Int, endIndex: Int) {
            var start = startIndex
            var end = endIndex
            while (start < end) {
                swap(inputArray, start, end)
                start++
                end--
            }
        }

        fun swap(inputString: CharArray, start: Int, end: Int) {
            val temp = inputString[start]
            inputString[start] = inputString[end]
            inputString[end] = temp
        }
    }
}