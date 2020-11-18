package Algorithm.string

import java.util.*
import kotlin.collections.HashMap

class StringUtils {
    companion object {
        @JvmStatic
        fun countVowels(str: String?): Int {
            if (str == null)
                return 0

            var count = 0
            val vowels = "aeiou"

            for (ch in str)
                if (vowels.contains(ch, true)) count++

            return count
        }

        @JvmStatic
        fun reverse(str: String?): String {
            if (str == null)
                return ""

            val reversed = StringBuilder()
            for (i in str.length - 1 downTo 0)
                reversed.append(str[i])

            return reversed.toString()
        }

        @JvmStatic
        fun reverseWords(sentence: String?): String {
            if (sentence == null)
                return ""

            val words = sentence.trim().split(' ')
            val reversed = StringBuilder()
            for (i in words.size - 1 downTo 0)
                reversed.append(words[i] + " ")

            return reversed.toString().trim()
        }

        @JvmStatic
        fun areRotations(str1: String?, str2: String?): Boolean {
            if (str1 == null || str2 == null || str1.length != str2.length)
                return false

            // Method 1
            if (str1.length < 100000)
                return (str1 + str1).contains(str2)

            // Method 2 for strings with size > 100000
            var index1 = 0
            var index2 = str2.indexOf(str1[index1])
            if (str1.length != str2.length || index2 == -1)
                return false

            while (index1 < str1.length) {
                if (str1[index1] != str2[index2]) return false

                index1++
                index2 = (index2 + 1) % str1.length
            }

            return true
        }

        @JvmStatic
        fun removeDuplicates(str: String?): String {
            if (str == null)
                return ""

            val output = StringBuilder()
            val seen = HashSet<Char>()

            for (ch in str)
                if (!seen.contains(ch)) {
                    seen.add(ch)
                    output.append(ch)
                }

            return output.toString()
        }

        @JvmStatic
        fun getMaxOccurringChar(str: String?): Char {
            if (str == null || str.isEmpty())
                throw IllegalArgumentException()

            val frequencies = HashMap<Char, Int>()

            for (ch in str)
                frequencies.put(ch, (frequencies[ch] ?: 0) + 1)

            var max = 0
            var result = ' '
            for (ch in frequencies.keys)
                if (frequencies[ch] ?: 0 > max) {
                    max = frequencies[ch] ?: 0
                    result = ch
                }

            return result
        }

        @JvmStatic
        fun getMaxOccurringASCIIChar(str: String?): Char {
            if (str == null || str.isEmpty())
                throw IllegalArgumentException()

            val ASCII_SIZE = 256
            val frequencies = IntArray(ASCII_SIZE)
            for (ch in str)
                frequencies[ch.toInt()]++

            var max = 0
            var result = ' '
            for (i in frequencies.indices)
                if (frequencies[i] > max) {
                    max = frequencies[i]
                    result = i.toChar()
                }

            return result
        }

        @JvmStatic
        fun capitalizeWords(sentence: String?): String {
            if (sentence == null || sentence.trim().isEmpty())
                return ""

            val words = sentence.trim().replace(Regex(" +"), " ").split(" ").toMutableList()
            for (i in words.indices)
                words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase()

            return words.joinToString(" ")
        }


        @JvmStatic
        fun areAnagrams(first: String, second: String): Boolean {
            return areAnagrams2(first, second)
        }

        /**
         * Runs in O(n log n)
         */
        private fun areAnagrams1(first: String, second: String): Boolean {
            if (first.length != second.length)
                return false

            val array1 = first.toCharArray()
            val array2 = second.toCharArray()

            Arrays.sort(array1)
            Arrays.sort(array2)

            return Arrays.equals(array1, array2)
        }

        /**
         * Runs in O(n) time
         */
        private fun areAnagrams2(first: String?, second: String?): Boolean {
            var first = first
            var second = second
            if (first == null || second == null) return false
            val ENGLISH_ALPHABET = 26
            val frequencies = IntArray(ENGLISH_ALPHABET)
            first = first.toLowerCase()
            for (i in 0 until first.length) frequencies[first[i] - 'a']++
            second = second.toLowerCase()
            for (i in 0 until second.length) {
                val index = second[i] - 'a'
                if (frequencies[index] == 0) return false
                frequencies[index]--
            }
            return true
        }
    }


}