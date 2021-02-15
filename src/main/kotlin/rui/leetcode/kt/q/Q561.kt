package rui.leetcode.kt.q

class Q561 {
    fun arrayPairSum(nums: IntArray): Int {
        // 方法1
        // 贪心算法
        // 排序之后，两个一对，取最小的那个累加
        // AC 348ms 40.7mb
        nums.sort()
        var i = 0
        var answer = 0
        while (i < nums.size) {
            answer += nums[i]
            i += 2
        }
        return answer
    }
}