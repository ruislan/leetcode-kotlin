package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertEquals

class Q1048 {
    fun lastStoneWeight(stones: IntArray): Int {
        val que = java.util.PriorityQueue<Int> { o1, o2 -> o2 - o1 }
        for (x in stones) que.offer(x)
        while (que.size > 1) {
            val y = que.poll()
            val x = que.poll()
            if (y != x) que.offer(y - x)
        }
        return que.poll() ?: 0
    }

    @Test
    fun test() {
        assertEquals(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)), 1)
    }
}