package Algorithm.sort

class SelectionSort {
    fun sort(array: IntArray) {
        for (i in 0 until array.size - 1) {// 0 .... size - 2
            var minIndex = findMinIndex(array, i)
            swap(array, i, minIndex)
        }

    }

    private fun findMinIndex(array: IntArray, from: Int): Int {
        var minIndex = from
        for (j in from until array.size)
            if (array[j] < array[minIndex])
                minIndex = j

        return minIndex
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}