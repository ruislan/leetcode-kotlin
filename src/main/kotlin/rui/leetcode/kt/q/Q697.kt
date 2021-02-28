package rui.leetcode.kt.q

class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        // 方法1
        // 滑动窗口解法
        // 先求出数组的度（degree）
        // 然后移动窗口，当窗口中的数字的频率正好等于度时
        // 我们收缩窗口到保持这个度的最小，然后求出距离
        // 所有的距离中最小的就是结果
        // AC 316ms 38mb
        val freq = HashMap<Int, Int>()
        for (n in nums) freq.compute(n) { _, v -> if (v == null) 1 else v + 1 }
        val degree = freq.map { it.value }.max()!!
        val n = nums.size
        var lo = 0
        var answer = n + 1
        val windowFreq = HashMap<Int, Int>()
        for (hi in 0 until n) {
            val count = windowFreq.compute(nums[hi]) { _, v -> if (v == null) 1 else v + 1 }!!
            if (count < degree) continue
            while (nums[lo] != nums[hi]) {
                windowFreq[nums[lo]] = windowFreq[nums[lo]]!! - 1
                lo += 1
            }
            if (count == degree) answer = kotlin.math.min(answer, hi - lo + 1)
        }
        return answer
    }
}