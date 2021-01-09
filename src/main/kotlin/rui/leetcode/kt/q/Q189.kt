package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertTrue

class Q189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        // 方法1
        // 直接一个一个的移动
        // 只有一个中间变量last，满足原地移动的条件
        // 时间复杂度O(k*(n - 1))
        // Passed 480ms 36.7mb
//        if (nums.isEmpty()) return
//        val n = nums.size
//        val k = k % n
//        for (i in 0 until k) {
//            val last = nums[n - 1]
//            for (j in n - 1 downTo 1) {
//                nums[j] = nums[j - 1]
//            }
//            nums[0] = last
//        }

        // 方法2
        // 环状替换
        // 就是将nums[0] -> nums[0 + k] -> nums[0 + 2k].. -> nums[0]
        // 然后nums[1] -> nums[1 + k] .. -> nums[1]
        // 一直到所有的数字都被替换过了
        // 所以这里需要设置几个参数
        // count:已经替换的数字统计
        // ptr：当前0-k的起点
        // i: 当前要移动的数字的索引
        // cur:当前要移动的数字
        // j: 要移动到的位置的索引
        // next:要移动到的位置的数字
        // 我们通过循环来不停的移动数字，直到当前的索引i == ptr也就是回到了起点
        // Passed 232ms 35.7mb
//        if (nums.isEmpty()) return
//        val n = nums.size
//        val k = k % n
//
//        var ptr = 0
//        var count = 0
//        while (count < n) {
//            var i = ptr
//            var cur = nums[i]
//            while (true) {
//                val j = (i + k) % n
//                val next = nums[j]
//
//                // 移动
//                nums[j] = cur
//                i = j // 转换下一个索引为当前索引
//                cur = next // 转换下一个数字为当前数字
//
//                count += 1 // 增加一个移动的数字
//                if (ptr == i) break // 如果回到起点了，就退出
//            }
//            ptr += 1
//        }

        // 方法3
        // 我们观察范例数组：[1，2，3，4，5，6，7] ，k = 3
        // 输出：[5,6,7,1,2,3,4]
        // 我们发现在范围[0 until k]和[k until n]两个范围
        // 如果我们分别翻转两个范围，那么就会得到：
        // [7,6,5,4,3,2,1]，正好是原数组的翻转
        // Passed 228ms 37.5mb
        if (nums.isEmpty()) return
        val n = nums.size
        val k = k % n

        nums.reverse()

        for (i in 0 until k / 2) {
            val j = k - 1 - i
            nums[i] = nums[i] xor nums[j]
            nums[j] = nums[i] xor nums[j]
            nums[i] = nums[i] xor nums[j]
        }

        for (i in k until k + (n - k) / 2) {
            val j = n - 1 - i + k
            nums[i] = nums[i] xor nums[j]
            nums[j] = nums[i] xor nums[j]
            nums[i] = nums[i] xor nums[j]
        }
    }

    @Test
    fun test() {
        val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val k = 3
        rotate(arr, k)
        assertTrue(intArrayOf(5, 6, 7, 1, 2, 3, 4).contentEquals(arr))
    }
}