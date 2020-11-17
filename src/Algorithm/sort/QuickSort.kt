package Algorithm.sort

class QuickSort {
    fun sort(array: IntArray) {
        sort(array, 0, array.size - 1)
    }

    private fun sort(array: IntArray, start: Int, end: Int) {
        if (start >= end)
            return

        var boundary = partition(array, start, end)

        sort(array, start, boundary - 1)
        sort(array, boundary + 1, end)
    }

    private fun partition(array: IntArray, start: Int, end: Int): Int {
        var pivot = array[end]
        var boundary = start - 1

        for (i in start..end)
            if (array[i] <= pivot)
                swap(array, i, ++boundary)

        return boundary
    }

    private fun swap(array: IntArray, index1: Int, index2: Int) {
        val temp = array[index1]
        array[index1] = array[index2]
        array[index2] = temp
    }
}