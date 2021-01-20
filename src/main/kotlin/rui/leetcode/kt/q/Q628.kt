package rui.leetcode.kt.q

class Q628 {
    fun maximumProduct(nums: IntArray): Int {
        // 方法1
        // 有一个陷阱点，就是两个负数乘积是正数
        // Passed
        val n = nums.size
        nums.sort()
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3])
    }
}