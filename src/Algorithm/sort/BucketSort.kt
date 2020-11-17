package Algorithm.sort

import java.lang.IllegalArgumentException
import java.util.*
import kotlin.collections.ArrayList

class BucketSort {
    fun sort(array: IntArray, numberOfBuckets: Int) {
        if (numberOfBuckets < 1 || numberOfBuckets > array.size)
            throw IllegalArgumentException()

        var i = 0
        for (bucket in createBuckets(array, numberOfBuckets)) {
            Collections.sort(bucket)
            for (item in bucket)
                array[i++] = item
        }
    }

    private fun createBuckets(array: IntArray, numberOfBuckets: Int): List<List<Int>> {
        val buckets = ArrayList<ArrayList<Int>>()
        for (i in 0 until numberOfBuckets)
            buckets.add(ArrayList())

        for (item in array) {
            var index = item / numberOfBuckets
            if (index >= numberOfBuckets) index = numberOfBuckets - 1
            buckets.get(index).add(item)
        }

        return buckets
    }
}