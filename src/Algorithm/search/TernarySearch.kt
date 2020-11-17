package Algorithm.search

class TernarySearch {
    fun search(array: IntArray, target: Int): Int {
        return search(array, target, 0, array.size - 1)
    }

    private fun search(array: IntArray, target: Int, left: Int, right: Int): Int {
        if (left > right) return -1

        val partitionSize = (right - left) / 3

        val mid1 = left + partitionSize
        val mid2 = right - partitionSize

        if (array[mid1] == target) return mid1
        if (array[mid2] == target) return mid2
        if (target < array[mid1]) return search(array, target, left, mid1 - 1)
        return if (target > array[mid2]) search(array, target, mid2 + 1, right) else search(array, target, mid1 + 1, mid2 - 1)
    }
}