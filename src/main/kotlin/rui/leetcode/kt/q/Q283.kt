package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertTrue

class Q283 {
    fun moveZeroes(nums: IntArray): Unit {
        // 方法1
        // 暴力法
        // Passed 328ms 36.7mb
//        for (i in nums.indices) {
//            for (j in i + 1 until nums.size) {
//                if (nums[i] == 0) {
//                    nums[i] = nums[j]
//                    nums[j] = 0
//                }
//            }
//        }

        // 方法2
        // 暴力法优化
        // Passed 280ms 36.6mb
//        for (i in nums.indices) {
//            for (j in i until nums.size) {
//                if (nums[j] != 0) {
//                    nums[i] = nums[j]
//                    if (i != j) nums[j] = 0
//                    break
//                }
//            }
//        }

        // 方法3
        // 将正确的数字放入正确的位置
        // 我们用一个ptr来表示当前位置应该放入的正确数字，从0开始
        // 当我们遇到第一个不为0的数字，我们就将其放入这个ptr的位置，
        // ptr向前移动一格
        // 这样当我们迭代完一次数组，不为0的数字都移动到了前面
        // 剩下的数字都设置为0即可
        // Passed 220ms 37.2mb
        var ptr = 0
        for (x in nums) {
            if (x != 0) {
                nums[ptr] = x
                ptr += 1
            }
        }
        for (i in ptr until nums.size) {
            nums[i] = 0
        }
    }

    @Test
    fun test() {
        val res = intArrayOf(1)
        moveZeroes(res)
        assertTrue(res.contentEquals(intArrayOf(1)))
    }
}