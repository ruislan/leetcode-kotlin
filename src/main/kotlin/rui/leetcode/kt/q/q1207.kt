package rui.leetcode.kt.q

import org.junit.Assert.*
import org.junit.Test

class Q1207 {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        // 方法1
        // 使用hashmap存储数字和频率，然后查看频率是否都相同
        // Passed 164ms 33.2mb
        val numberFreq = mutableMapOf<Int, Int>()
        for (n in arr) numberFreq[n] = numberFreq.getOrDefault(n, 0) + 1
        val freqSet = mutableSetOf<Int>()
        for ((_, v) in numberFreq) if (!freqSet.add(v)) return false
        return true
    }

    @Test
    fun test() {
        assertTrue(uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
        assertFalse(uniqueOccurrences(intArrayOf(1, 2)))
        assertTrue(uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)))
    }
}