package Algorithm.search

import kotlin.math.sqrt

class JumpSearch {
    /**
     * Only works correctly with sorted arrays
     */
    fun search(array: IntArray, target: Int): Int {
        val blockSize = sqrt(array.size.toDouble()).toInt()

        var start = 0
        var next = blockSize

        while (start < array.size && array[next - 1] < target) {
            start = next
            next += blockSize
            if (next > array.size)
                next = array.size
        }

        for (i in start until next)
            if (array[i] == target)
                return i

        return -1
    }
}