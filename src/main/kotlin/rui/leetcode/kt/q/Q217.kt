package rui.leetcode.kt.q

class Q217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        // 方法1
        // 直接排序，这样相同的都会排在一起
        // 然后检查相邻的两个，只要有一样的，直接返回true
        // 不一样的返回false
        // 时间O(nlogn + n)
        // Passed 288ms 40.8mb
//        nums.sort()
//        for (i in 1 until nums.size) {
//            if (nums[i] == nums[i - 1]) {
//                return true
//            }
//        }
//        return false

        // 方法2
        // 用Hashset，只需要一遍扫描，set不能插入说明有相同的
        // 时间O(n)
        // Passed 264ms 41mb
        val sets = HashSet<Int>()
        for (x in nums) {
            if (!sets.add(x)) {
                return true
            }
        }
        return false
    }
}