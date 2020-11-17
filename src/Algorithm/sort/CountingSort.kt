package Algorithm.sort

class CountingSort {
    fun sort(array: IntArray, max: Int) {
        val counts = IntArray(max + 1)
        for (item in array)
            counts[item]++

        var k = 0
        for (i in counts.indices)
            for (j in 0 until counts[i])
                array[k++] = i
    }
}