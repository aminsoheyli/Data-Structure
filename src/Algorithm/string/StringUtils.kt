package Algorithm.string

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

            return  reversed.toString().trim()
        }
    }
}