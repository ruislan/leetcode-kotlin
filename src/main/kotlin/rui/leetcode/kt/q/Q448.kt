package rui.leetcode.kt.q

class Q448 {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        // 方法1
        // 记录出现过的数字，统计未出现的
        // 用到了额外的空间
        // AC 416ms 45.7mb
        val n = nums.size
        val freq = BooleanArray(n + 1)
        for (x in nums) freq[x] = true
        val answer = mutableListOf<Int>()
        for (i in 1..n) {
            if (!freq[i]) {
                answer.add(i)
            }
        }
        return answer
    }
}