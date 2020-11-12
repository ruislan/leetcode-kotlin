package rui.leetcode.kt.q

import org.junit.Test
import rui.leetcode.kt.toPrettyString
import kotlin.test.assertTrue

class Q922 {
    fun sortArrayByParityII(A: IntArray): IntArray {
        // 方法1
        // 双指针，
        // 从左向右找偶数，从右向左找奇数（或者两个都从起点找都没问题）
        // 找到之后交换
        // 当左边到达终点或者右边到达起点，完成交换
        // Passed 360 38.8mb
        var lo = 0
        var hi = if (A.size and 1 == 1) A.size - 2 else A.size - 1
        while (lo < A.size || hi >= 0) {
            while (lo < A.size && A[lo] and 1 == 0) {
                lo += 2
            }
            while (hi >= 0 && A[hi] and 1 == 1) {
                hi -= 2
            }
            if (lo < A.size && hi >= 0) {
                A[lo] = A[lo] xor A[hi]
                A[hi] = A[lo] xor A[hi]
                A[lo] = A[lo] xor A[hi]
            }
        }
        return A
    }

    @Test
    fun test() {
        assertTrue(sortArrayByParityII(intArrayOf()).contentEquals(intArrayOf()))
        assertTrue(sortArrayByParityII(intArrayOf(1, 2)).contentEquals(intArrayOf(2, 1)))
        assertTrue(sortArrayByParityII(intArrayOf(2, 1)).contentEquals(intArrayOf(2, 1)))
        val answer = sortArrayByParityII(intArrayOf(4, 2, 5, 7))
        assertTrue(arrayOf(intArrayOf(4, 5, 2, 7), intArrayOf(2, 5, 4, 7), intArrayOf(2, 7, 4, 5)).any {
            it.contentEquals(answer)
        })
    }
}