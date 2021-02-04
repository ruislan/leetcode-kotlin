package rui.leetcode.kt.q

class Q643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        // 方法1
        // 构建一个长度为K的滑动窗口
        // 求出窗口内的和sum
        // 向右滑动时维护sum，加入右端的数字，减去左端的数字
        // 求出平均值，看是否是最大值
        // AC 444ms 41.5mb
        var sum = (0 until k).map { nums[it] }.sum().toDouble()
        var answer = sum / k
        for (i in k until nums.size) {
            sum = sum + nums[i] - nums[i - k]
            answer = Math.max(answer, sum / k)
        }
        return answer
    }
}