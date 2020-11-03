package rui.leetcode.kt.q

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class Q941 {
    fun validMountainArray(A: IntArray): Boolean {
        // 方法1
        // 找出数组最大值top
        // 检查top左边（包含top）是否连续上升
        // 检查top右边（包含top）是否连续下降
//        if (A.size < 3) return false
//
//        var top = Pair(0, A[0])
//        for (i in 1 until A.size)
//            if (top.second < A[i])
//                top = Pair(i, A[i])
//
//        if (top.first == 0 || top.first == A.size - 1)
//            return false
//
//        for (i in 1..top.first)
//            if (A[i - 1] >= A[i])
//                return false
//
//        for (i in (top.first + 1) until A.size)
//            if (A[i - 1] <= A[i])
//                return false
//
//        return true

        // 方法2
        // 一次遍历
        // 先检查1 until size，比较A[i-1]与A[i]的大小：
        //     如果 A[i-1] >= A[i]:
        //         得到这个索引
        // 如果这个索引是第一个或者最后一个：
        //     返回false
        // 再检查这个索引 until size，比较A[i-1]与A[i]的大小：
        //     如果 A[i-1] <= A[i]:
        //         返回false
        // 最后返回true
        if (A.size < 3) return false
        
        var i = 0
        while (i < A.size - 1) {
            if (A[i] >= A[i + 1]) break
            i += 1
        }

        if (i == 0 || i == A.size - 1) return false

        while (i < A.size - 1) {
            if (A[i] <= A[i + 1]) return false
            i += 1
        }

        return true
    }

    @Test
    fun test() {
        assertFalse(validMountainArray(intArrayOf(3, 5, 5)))
        assertTrue(validMountainArray(intArrayOf(0, 3, 2, 1)))
        assertFalse(validMountainArray(intArrayOf(0, 1, 2, 3)))
        assertTrue(validMountainArray(intArrayOf(0, 1, 2, 3, 0)))
        assertFalse(validMountainArray(intArrayOf(3, 2, 1, 0)))
        assertFalse(validMountainArray(intArrayOf(3, 2, 1, 0, 1, 2, 3)))
    }
}