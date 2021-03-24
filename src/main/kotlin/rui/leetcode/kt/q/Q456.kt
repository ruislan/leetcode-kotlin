package rui.leetcode.kt.q

class Q456 {
    fun find132pattern(nums: IntArray): Boolean {
        // 方法1
        // 暴力解
        // n的值小于15000，所以n^2还可以接受
        // AC 484ms 36.8mb
//        val n = nums.size
//        for (i in 0 until n) {
//            var max = nums[i]
//            for (j in i + 1 until n) {
//                max = Math.max(max, nums[j])
//                if (nums[j] < max && nums[j] > nums[i]) return true
//            }
//        }
//        return false

        // 方法2
        // 利用栈
        // 首先记录所有位置的最小值 min，
        // 这样每个min[i]对应的nums[i]至少满足了1，3模式，接下来就是找2
        // 然后按倒序迭代nums
        // 如果 nums[i] 比  min[i]大，（满足1，3模式）
        //     循环检查栈顶的值比 min[i]小或者等于，就出栈
        //     在栈顶的值比 nums[i]小，就达成了132模式（这里注意栈顶必然比min[i]大）
        //     栈顶没有值，就添加nums[i]进去
        // AC 248ms 36.3mb
        val min = IntArray(nums.size)
        min[0] = nums[0]
        for (i in 1 until nums.size) min[i] = Math.min(nums[i], min[i - 1])
        println(min.joinToString(", "))
        val stack = java.util.Stack<Int>()
        for (i in nums.size - 1 downTo 1) {
            if (nums[i] > min[i]) {
                while (stack.isNotEmpty() && stack.peek() <= min[i]) stack.pop()
                if (stack.isNotEmpty() && stack.peek() < nums[i]) return true
                stack.push(nums[i])
            }
        }
        return false
    }
}