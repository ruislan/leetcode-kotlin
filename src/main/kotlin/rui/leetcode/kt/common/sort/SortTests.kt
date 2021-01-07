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
            val a0 = origin.clone()
            a0.shuffle()
            val a1 = a0.clone()
            val a2 = a0.clone()
            val a3 = a0.clone()
            println("Sort Comparison with [${origin.size}] items:")
            println("[Default Sort] use:${measureTimeMillis { a0.sort() }} ms")
            println("[Heap Sort] use:${measureTimeMillis { a1.heapSort() }} ms")
            println("[Merge Sort] use:${measureTimeMillis { a2.mergeSort() }} ms")
            println("[Quick Sort] use:${measureTimeMillis { a3.quickSort() }} ms")
            println()
            assertTrue(a1.contentEquals(a0))
            assertTrue(a2.contentEquals(a0))
            assertTrue(a3.contentEquals(a0))
        }
    }
}