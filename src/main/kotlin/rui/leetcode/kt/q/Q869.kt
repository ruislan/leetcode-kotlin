package rui.leetcode.kt.q

class Q869 {
    fun isMonotonic(A: IntArray): Boolean {
        // 方法1
        // 先检查一遍非递减，再检查一遍非递增
        // AC 592ms 45.6mb
        var answer = true
        val n = A.size
        for (i in 1 until n) {
            if (A[i] > A[i - 1]) {
                answer = false
            }
        }
        if (answer) return answer
        answer = true
        for (i in 1 until n) {
            if (A[i] < A[i - 1]) {
                answer = false
            }
        }
        return answer
    }
}