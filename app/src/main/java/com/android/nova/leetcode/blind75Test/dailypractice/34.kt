package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class `34` {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val digits = "23"
            val combinations = letterCombinations(digits)
            println("Combinations for digits $digits: $combinations")
        }
        fun letterCombinations(digits: String): List<String> {
            val numLettersMap = HashMap<Char, MutableList<Char>>()
            numLettersMap['2'] = mutableListOf('a', 'b', 'c')
            numLettersMap['3'] = mutableListOf('d', 'e', 'f')
            numLettersMap['4'] = mutableListOf('g', 'h', 'i')
            numLettersMap['5'] = mutableListOf('j', 'k', 'l')
            numLettersMap['6'] = mutableListOf('m', 'n', 'o')
            numLettersMap['7'] = mutableListOf('p', 'q', 'r', 's')
            numLettersMap['8'] = mutableListOf('t', 'u', 'v')
            numLettersMap['9'] = mutableListOf('w', 'x', 'y', 'z')

            val result = ArrayList<String>()

            fun dfs(numIndex: Int, sb: StringBuilder) {
                if (numIndex >= digits.length) {
                    val combination = sb.toString()
                    result.add(combination)
                    return
                }
                val number = digits[numIndex]
                if (number == '0' || number == '1') {
                    return
                }
                val letterCandidatesList = numLettersMap.getOrDefault(number, mutableListOf())

                for (letter in letterCandidatesList) {
                    sb.append(letter)
                    dfs(numIndex + 1, sb)
                }
            }

            return result
        }
    }
}