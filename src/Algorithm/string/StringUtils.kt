package Algorithm.string

import java.lang.IllegalArgumentException
import java.util.HashSet

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
    }
}