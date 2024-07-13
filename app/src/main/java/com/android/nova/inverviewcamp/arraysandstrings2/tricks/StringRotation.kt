package com.android.nova.inverviewcamp.arraysandstrings2.tricks
/**
 * (Level: Easy) Check if a string A
 * is a rotation of another string B.
 * For example, "atbobc" is a rotation of "bobcat".
 */
class StringRotation {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputString = "catbob"
            val baseString = "bobcat"
            println("Checking if $inputString is a rotation of $baseString")

            checkForRotation(inputString, baseString)
        }

        fun checkForRotation(inputString: String, baseString:String) {
            val concatBaseString = baseString + "" + baseString
            if (concatBaseString.contains(inputString)) {
                println("$inputString is a rotation of $baseString")
                return
            }
            println("$inputString is NOT a rotation of $baseString")
        }
    }
}