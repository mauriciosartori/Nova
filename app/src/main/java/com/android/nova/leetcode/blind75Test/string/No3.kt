package com.android.nova.leetcode.blind75Test.string
/**
 *
 */
class No3 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("")
        }
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val anagramMap = HashMap<String, MutableList<String>>()
            for (word in strs) {
                var wordMapKey = getAnagramMapKey(anagramMap, word)
                var wordArrayList = anagramMap.getOrDefault(wordMapKey, ArrayList<String>())
                wordArrayList.add(word)
                anagramMap[wordMapKey] = wordArrayList
            }

            val result = ArrayList<List<String>>()
            for ((key, value) in anagramMap) {
                result.add(value)
            }
            return result
        }

        fun getAnagramMapKey(anagramMap: HashMap<String, MutableList<String>>, word: String): String {
            if (anagramMap.size == 0) {
                return word
            }

            for ((keyAnagram, listValues) in anagramMap){
                if (isAnagram(keyAnagram, word)) {
                    return keyAnagram
                }
            }
            return word
        }

        fun isAnagram(s:String, t:String): Boolean {
            val sMap = HashMap<Char, Int>()
            val tMap = HashMap<Char, Int>()
            for (sChar in s) {
                val occurrences = sMap.getOrDefault(sChar, 0)
                sMap[sChar] = occurrences + 1
            }

            for (tChar in t) {
                val occurrences = tMap.getOrDefault(tChar, 0)
                tMap[tChar] = occurrences + 1
            }
            if (tMap.size != sMap.size) {
                return false
            }
            for ((key, value) in tMap) {
                if (sMap.getOrDefault(key, -1) != value) {
                    return false
                }
            }
            return true
        }
    }
}