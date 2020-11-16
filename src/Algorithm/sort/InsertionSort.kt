package Algorithm.sort

class InsertionSort {
    fun sort(array: IntArray) {
        for (i in array.indices) {
            val current = array[i]
            var j = i - 1
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
    }
}