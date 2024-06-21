package com.android.nova.inverviewcamp.arraysandstrings1.reversetraversing

/**
 ** Given a sentence, reverse the words of the sentence.
 * For example,"i live in a house" becomes "house a in live i"
 **/
class ReverseTraversingH1KVersion1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("The input sting is I live in a house")
            reverseString("i live in a house")
        }
        fun reverseString(input: String) {
            val sb = StringBuilder()
            var endIndex = input.length - 1

            for (i in input.length - 1 downTo 0) {
                if (input[i] == ' ') {
                    sb.append(input.substring(i + 1, endIndex + 1))
                    sb.append(' ')
                    endIndex = i - 1
                }
            }

            // For this specific case I need to
            // add the base case manually afterwards
            //println("El index al final es $endIndex")
            sb.append(input.substring(0, endIndex + 1))

            println("The super result is -$sb-")
        }
    }
}