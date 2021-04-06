package rui.leetcode.kt.q

class Q80 {
    fun removeDuplicates(nums: IntArray): Int {
        val n = nums.size
        var lo = 0
        var cur = nums[0]
        var curFreq = 1
        for (i in 1 until n) {
            if (cur == nums[i]) curFreq += 1
            else {
                cur = nums[i]
                curFreq = 1
            }
            if (curFreq > 2) {
                lo = i
                break
            }
        }
        for (hi in lo + 1 until n) {
            if (cur == nums[hi]) curFreq += 1
            else {
                cur = nums[hi]
                curFreq = 1
            }
            if (curFreq <= 2) {
                nums[lo] = nums[hi]
                lo += 1
            }
        }
        return lo
    }
}