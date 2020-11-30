package rui.leetcode.kt.q

class Q34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        // 方法1
        // 有序数组只需要二分查找
        // 这里需要一个变形的二分查找
        // 也就是要找出上界和下界
        // Passed 232ms 38.4mb
//        var lo = 0
//        var hi = nums.size - 1
//
//        while (lo <= hi) {
//            val mid = lo + (hi - lo) / 2
//            if (target <= nums[mid]) {
//                hi = mid - 1
//            } else {
//                lo = mid + 1
//            }
//        }
//        val lower = lo
//
//        lo = 0
//        hi = nums.size - 1
//        while (lo <= hi) {
//            val mid = lo + (hi - lo) / 2
//            if (target >= nums[mid]) {
//                lo = mid + 1
//            } else {
//                hi = mid - 1
//            }
//        }
//        val higher = hi
//
//        return if (lower > higher) intArrayOf(-1, -1) else intArrayOf(lower, higher)

        // 方法2
        // 只需要找下界，然后找到target + 1的下界
        // 结果就是target + 1的下界 - 1
        // Passed 236ms 38.5mb
        fun findLower(nums: IntArray, target: Int): Int {
            var lo = 0
            var hi = nums.size - 1
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                if (nums[mid] >= target) {
                    hi = mid - 1
                } else {
                    lo = mid + 1
                }
            }
            return lo
        }

        val lower1 = findLower(nums, target)
        val lower2 = findLower(nums, target + 1)
        return if (lower2 <= lower1) intArrayOf(-1, -1) else intArrayOf(lower1, lower2 - 1)
    }
}