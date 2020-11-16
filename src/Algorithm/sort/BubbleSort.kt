package Algorithm.sort

class BubbleSort {
    fun sort(array: IntArray) {
        for (i in array.indices) {
            var isSorted = true
            for (j in 1 until array.size - i)
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1)
                    isSorted = false
                }
            if (isSorted) return
        }
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}