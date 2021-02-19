package rui.leetcode.kt.q

class Q1004 {
    fun longestOnes(A: IntArray, K: Int): Int {
        // 方法1
        // 利用滑动窗口
        // 统计窗口内的0的个数，超出K个了，就缩小窗口到符合0的个数为K个
        // 返回窗口最大值
        // AC 324ms 38.8mb
        val n = A.size
        var lo = 0
        var answer = 0
        var zeros = 0
        for (hi in 0 until n) {
            if (A[hi] == 0) {
                zeros += 1
                while (zeros > K) {
                    if (A[lo] == 0) zeros -= 1
                    lo += 1
                }
            }
            answer = Math.max(answer, hi - lo + 1)
        }
        return answer
    }
}