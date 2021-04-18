package rui.leetcode.kt.q

class Q26 {
    fun removeDuplicates(nums: IntArray): Int {
        // 方法1
        // 双指针，快的指针检查新数据
        // 慢的指针等待检查，如果快慢不相等的时候
        // 慢指针的下一个被指向新的数据
        // 最后返回慢指针的位置就是结果
        // AC 260ms 38.5mb
        val n = nums.size
        if (n < 2) return n
        var lo = 0
        for (hi in 1 until n) {
            if (nums[hi] != nums[lo]) {
                lo += 1
                nums[lo] = nums[hi]
            }
        }
        return lo + 1
    }
}