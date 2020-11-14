package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertTrue

class Q1122 {
    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        // 方法1
        // 将所有的arr1数字存储到桶中
        // 遍历arr2，读取桶内容依次填入
        // 遍历桶，将还存在的数字依次填入
        // Passed 204ms 34.7mb
        val bucket = IntArray(1001)
        arr1.forEach { bucket[it] += 1 }
        val answer = IntArray(arr1.size)
        var i = 0
        arr2.forEach {
            (0 until bucket[it]).forEach { _ ->
                answer[i++] = it
                bucket[it] -= 1
            }
        }
        bucket.forEachIndexed { it, n ->
            (0 until n).forEach { _ ->
                answer[i++] = it
            }
        }
        return answer
    }

    @Test
    fun test() {
        assertTrue(relativeSortArray(intArrayOf(), intArrayOf()).contentEquals(intArrayOf()))
        assertTrue(relativeSortArray(
                intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19),
                intArrayOf(2, 1, 4, 3, 9, 6))
                .contentEquals(
                        intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19)
                )
        )
    }
}