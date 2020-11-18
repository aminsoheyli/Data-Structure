package Algorithm.search

import kotlin.math.sign

class BinarySearch {
    /**
     * Only works correctly with sorted arrays
     */
    fun search(array: IntArray, target: Int): Int {
        return searchRecursive(array, target)
    }

    private fun searchRecursive(array: IntArray, target: Int): Int {
        return searchRecursive(array, target, 0, array.size - 1)
    }

    private fun searchRecursive(array: IntArray, target: Int, left: Int, right: Int): Int {
        if (right < left)
            return -1

        val middle = (left + right) / 2

        if (array[middle] == target)
            return middle
        if (target < array[middle])
            return searchRecursive(array, target, left, middle - 1)

        return searchRecursive(array, target, middle + 1, right)
    }

    private fun searchIterative(array: IntArray, target: Int): Int {
        var left = 0
        var right = array.size - 1

        while (left <= right) {
            var middle = (left + right) / 2

            if (array[middle] == target)
                return middle

            if (target < array[middle])
                right = middle - 1
            else
                left = middle + 1
        }

        return -1
    }
}