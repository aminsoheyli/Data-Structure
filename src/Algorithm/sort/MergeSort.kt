package Algorithm.sort

class MergeSort {
    fun sort(array: IntArray) {
        if (array.size < 2)
            return

        val middle = array.size / 2

        var left = array.sliceArray(0 until middle)
        var right = array.sliceArray(middle until array.size)

        sort(left)
        sort(right)

        merge(left, right, array)
    }

    private fun merge(left: IntArray, right: IntArray, result: IntArray) {
        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] <= right[j])
                result[k++] = left[i++]
            else
                result[k++] = right[j++]
        }

        while (i < left.size)
            result[k++] = left[i++]

        while (j < right.size)
            result[k++] = right[j++]
    }
}