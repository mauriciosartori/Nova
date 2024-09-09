package com.android.nova.leetcode.blind75Test.string
/**
 *
 */
class No5 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun longestPalindrome(s: String): String {
            var wordSpaced = StringBuilder()
            for (index in 0 until s.length) {
                wordSpaced.append(s[index])
                if (index != s.length - 1) {
                    wordSpaced.append('_')
                }
            }

            var size = 0
            var result = ""
            for (index in 0 until wordSpaced.length) {
                val palindrom = getPalindrom(index, wordSpaced)
                val processedPal = palindrom.replace("_","")
                if (processedPal.length > size) {
                    result = processedPal
                    size = maxOf(processedPal.length, size)
                }
            }
            return result
        }

        fun getPalindrom(index: Int, wordSpaced: StringBuilder): String {
            var left = index - 1
            var right = index + 1
            var wordResult = StringBuilder()
            wordResult.append(wordSpaced[index])
            while (left >= 0 && right < wordSpaced.length) {
                if (wordSpaced[left] == wordSpaced[right]) {
                    val temp = StringBuilder()
                    temp.append(wordSpaced[left])
                    temp.append(wordResult)
                    temp.append(wordSpaced[right])
                    wordResult = temp
                } else {
                    break
                }
                left--
                right++
            }
            return wordResult.toString()
        }
    }
}