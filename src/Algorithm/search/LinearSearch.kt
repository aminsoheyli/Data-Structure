package Algorithm.search

class LinearSearch {
    fun search(array: IntArray, target: Int): Int {
        for (i in array.indices)
            if (array[i] == target)
                return i

        return -1
    }
}