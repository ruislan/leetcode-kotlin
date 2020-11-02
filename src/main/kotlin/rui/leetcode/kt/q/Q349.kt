package rui.leetcode.kt.q

import org.junit.Assert.assertTrue
import org.junit.Test
import rui.leetcode.kt.toPrettyString

class Q349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        // 方法1
        // 直接用hashset解决
        val sets = mutableSetOf<Int>()
        nums1.forEach { sets.add(it) }
        val answer = mutableSetOf<Int>()
        nums2.forEach { if (sets.contains(it)) answer.add(it) }
        return answer.toIntArray()
    }

    @Test
    fun test1() {
        assertTrue(intersection(intArrayOf(), intArrayOf()).contentEquals(intArrayOf()))
        assertTrue(intersection(intArrayOf(1), intArrayOf()).contentEquals(intArrayOf()))
        assertTrue(intersection(intArrayOf(1), intArrayOf(1)).contentEquals(intArrayOf(1)))
        assertTrue(intersection(intArrayOf(1, 2, 2, 1), intArrayOf(2, 2)).contentEquals(intArrayOf(2)))
        assertTrue(intersection(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4)).contentEquals(intArrayOf(9, 4)))
    }
}