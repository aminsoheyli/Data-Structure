package Algorithm.search

class ExponentialSearch {
    fun search(array: IntArray, target: Int): Int {
        var bound = 1

        while (bound < array.size && array[bound] < target)
            bound *= 2

        val left = bound / 2
        val right = Math.min(bound, array.size - 1)

        return BinarySearch().search(array, target, left, right)
    }
}