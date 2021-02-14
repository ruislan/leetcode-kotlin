package rui.leetcode.kt.q

class Q485 {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        // 方法1
        // 此题可以不使用滑动窗口的
        // 不过用这个简单的题来体验滑动窗口的概念还是挺有意义的
        // AC 272ms 36.5mb
        var answer = 0
        var lo = 0
        var hi = 0
        while (hi < nums.size) {
            if (nums[hi] != 1) {
                lo = hi + 1
            }
            answer = kotlin.math.max(answer, hi - lo + 1)
            hi += 1
        }
        return answer
    }
}