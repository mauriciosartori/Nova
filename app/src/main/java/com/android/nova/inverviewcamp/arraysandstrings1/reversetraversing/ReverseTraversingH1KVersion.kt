package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/**
 ** Given a sentence, reverse the words of the sentence.
 * For example,"i live in a house" becomes "house a in live i"
 **/
class ReverseTraversingH1KVersion {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("The input sting is I live in a house")
            reverseString("i live in a house")
        }
        fun reverseString(input:String) {
            val sb = StringBuilder()
            var currentWordEnd = input.length

            for (i in input.length - 1 downTo 0) {
                if (input[i] == ' ') {
                    if(sb.isNotEmpty()) {
                        sb.append(' ')
                    }
                    sb.append(input.substring(i + 1, currentWordEnd))
                    currentWordEnd = i
                }
            }
            // We were missing adding the first word
            sb.append(' ')
            sb.append(input.substring(0, currentWordEnd))

            println("The result is ${sb} ")
        }
    }
}