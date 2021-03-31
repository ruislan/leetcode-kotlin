package rui.leetcode.kt.q

import java.util.*

class Q90 {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        // 方法1
        // 首先进行排序，然后采用回溯算法即可解决
        // 去掉重复朴素的方法就是hashset，
        // 第二个方式就是如果当前数字和前一个数字相同，则不需要处理
        // AC 216ms 37.4mb
        nums.sort()
        val ans = mutableListOf<List<Int>>()
        backtrace(LinkedList<Int>(), 0, nums, ans)
        return ans
    }

    private fun backtrace(path: LinkedList<Int>, i: Int, nums: IntArray, ans: MutableList<List<Int>>) {
        ans.add(path.toList())
        if (i == nums.size) return
        for (j in i until nums.size) {
            if (j > i && nums[j] == nums[j - 1]) continue
            path.addLast(nums[j])
            backtrace(path, j + 1, nums, ans)
            path.removeLast()
        }
    }
}