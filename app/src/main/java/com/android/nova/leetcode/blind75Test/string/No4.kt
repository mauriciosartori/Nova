package com.android.nova.leetcode.blind75Test.string
/**
 *
 */
class No4 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val result = isValid("((")
            println("Result of No4 is $result" )
        }
        fun isValid(s: String): Boolean {
            if (s.length == 1) {
                return false
            }
            val stack = ArrayDeque<Char>()
            for (char in s){
                if (char == '(' || char == '[' || char == '{') {
                    stack.addFirst(char)
                } else {
                    val lastOpenedChar = stack.removeFirst()
                    when {
                        char == ')' -> {
                            if (lastOpenedChar != '(') {
                                return false
                            }
                        }
                        char == ']' -> {
                            if (lastOpenedChar != '[') {
                                return false
                            }
                        }
                        else -> {
                            if (lastOpenedChar != '{') {
                                return false
                            }
                        }
                    }
                }
            }
            return stack.isEmpty()
        }
    }
}