package com.android.nova.inverviewcamp.recursionbacktracking.permutationscombinations
/**
 * Phone Number Mnemonic Problem:
 * Given an N digit phone number,
 * print all the strings that can be made from that phone number.
 * Since 1 and 0 don't correspond to any characters, ignore them. For example:
 *
 * 213 => AD, AE, AF, BD, BE, BF, CD, CE, CF
 *
 * 456 => GJM, GJN, GJO, GKM, GKN, GKO,.. etc.
 */
class PhoneNumberMnemonic {
    companion object {
        val phoneKeyboard: Array<Array<Char>> = arrayOf(
            arrayOf(),            // 0
            arrayOf(),               // 1 (usually no letters associated)
            arrayOf('a', 'b', 'c'),  // 2
            arrayOf('d', 'e', 'f'),  // 3
            arrayOf('g', 'h', 'i'),  // 4
            arrayOf('j', 'k', 'l'),  // 5
            arrayOf('m', 'n', 'o'),  // 6
            arrayOf('p', 'q', 'r', 's'), // 7
            arrayOf('t', 'u', 'v'),  // 8
            arrayOf('w', 'x', 'y', 'z')  // 9
        )
        @JvmStatic
        fun main(args: Array<String>) {
            println("Phone keyboard problem")
            getPhoneCombinations(intArrayOf(9, 2, 7), CharArray(3),0, 0 )
        }

        fun getPhoneCombinations(inputArray: IntArray, bufferArray: CharArray, startIndex: Int, bufferIndex: Int) {
            // Add base cases
            if (bufferIndex >= bufferArray.size){

                println(bufferArray.contentToString())
                return
            }
            if (startIndex == inputArray.size) {

                return
            }

            // Added by the machine
            val digit = inputArray[startIndex]

            val letters =  phoneKeyboard[digit]
            if (letters.size == 0) {
                getPhoneCombinations(inputArray, bufferArray, startIndex + 1, bufferIndex)
            }


            for (i in letters.indices) {
                bufferArray[bufferIndex] = letters[i]
                getPhoneCombinations(inputArray, bufferArray, startIndex + 1, bufferIndex + 1)
            }

        }
    }
}