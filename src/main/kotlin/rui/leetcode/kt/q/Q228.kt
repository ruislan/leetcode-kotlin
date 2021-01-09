package rui.leetcode.kt.q

class Q228 {
    fun summaryRanges(nums: IntArray): List<String> {
        // 方法1
        // 设置一个开始位置lo = 0
        // 直接从1开始迭代数组
        // 如果有不连续递增1的，那么就看是否开始位置等于之前的位置
        // 如果相等，说明他们是同一个，那么输出nums[lo]
        // 如果不想等，那么说明有一个区间，那么输出nums[lo]->nums[i - 1]
        // Passed 172ms 32.9mb
        val answer = mutableListOf<String>()
        var lo = 0
        for (i in 1..nums.size) {
            if (i == nums.size || nums[i] - nums[i - 1] != 1) {
                if (lo == i - 1) {
                    answer.add("${nums[i - 1]}")
                } else {
                    answer.add("${nums[lo]}->${nums[i - 1]}")
                }
                lo = i
            }
        }
        return answer
    }
}