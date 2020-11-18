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
    }
}