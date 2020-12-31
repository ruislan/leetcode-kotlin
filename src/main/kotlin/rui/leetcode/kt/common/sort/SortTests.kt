package rui.leetcode.kt.common.sort

import org.junit.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertTrue


class SortTests {
    private val data = arrayOf(
            intArrayOf(),
            intArrayOf(1),
            intArrayOf(1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 5, 5, 5),
            (1..10000000).map { it }.toIntArray(),
    )

    @Test
    fun testMergeSort() {
        for (origin in data) {
            val x = origin.clone()
            x.shuffle()
            val y = x.clone()
            val z = x.clone()
            val tmX = measureTimeMillis { x.heapSort() }
            val tmY = measureTimeMillis { y.mergeSort() }
            val tmZ = measureTimeMillis { z.sort() }
            println("[Heap Sort] use:$tmX ms vs [Merge Sort]:$tmY ms vs [Default Sort]:$tmZ ms")
            assertTrue(y.contentEquals(x))
        }
    }
}