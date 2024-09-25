package com.android.nova.leetcode.blind75Test.dailypractice
/**
 *
 */
class No46 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun longestCommonSubsequence(text1: String, text2: String): Int {
            val memo = HashMap<Char, Int>()
            val smallTextMap = HashMap<Char, Int>()

            val longText = if (text1.length >= text2.length) text1 else text2
            val smallText = if (text1.length < text2.length) text1 else text2

            for ((i, character) in smallText.withIndex()) {
                smallTextMap[character] = i
            }

            var result = 0
            for (i in longText.length - 1 downTo 0) {
                val currentChar = longText[i]

                if (smallTextMap.contains(currentChar)) {
                    var smallIndex = i
                    var count = 1
                    val initIndex = smallTextMap.getOrDefault(currentChar, 0) + 1

                    for (j in initIndex until smallText.length) {
                        val indexInLongText = memo.getOrDefault(smallText[j], - 1)
                        if (indexInLongText != -1 && indexInLongText > smallIndex) {
                            count++
                            smallIndex = indexInLongText
                        } else {
                            break
                        }
                    }
                    result = maxOf(result, count)
                }
                memo[currentChar] = i
            }
            return result
        }
    }
}