package rui.leetcode.kt.q

class Q303 {
    // 方法1
    // 其实这题是个简单题，数据量在O(n)可接受范围内
    // 最简单的方法就是找到i - j范围然后做加法计算就行了
    // 方法2
    // 前缀和是一个不错的缓存，这样一来i - j其实就是
    // sum(j) - sum(i - 1)就行了
    // 方法3
    // 线段树(SegmentTree)，通过将数据存储成线段树的方式
    // 这样就很好的处理和了
    // 方法4
    // 树状数组(FenwickTree)
    // 通过将数据存储成树状数组的方式
    // AC 316ms 44.1mb
    class NumArray(nums: IntArray) {
        val arr = IntArray(nums.size + 1)

        init {
            for (i in nums.indices) treeUpdate(i + 1, nums[i])
        }

        fun lowerBit(x: Int) = x and (x - 1).inv()

        fun treeUpdate(i: Int, x: Int) {
            var j = i
            while (j < arr.size) {
                arr[j] += x
                j += lowerBit(j)
            }
        }

        fun treeQuery(i: Int): Int {
            var sum = 0
            var j = i
            while (j > 0) {
                sum += arr[j]
                j -= lowerBit(j)
            }
            return sum
        }

        fun sumRange(i: Int, j: Int): Int = treeQuery(j + 1) - treeQuery(i)
    }
}