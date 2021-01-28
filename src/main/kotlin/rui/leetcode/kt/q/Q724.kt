package rui.leetcode.kt.q

class Q724 {
    fun pivotIndex(nums: IntArray): Int {
        // 方法1
        // 分别求出
        //    左到右的前缀和
        //    右到左的前缀和
        // 然后两个前缀和相等的地方就是中间点
        // AC 272ms 38.1mb
        val n = nums.size
        if (n < 1) return -1
        val l2r = IntArray(n)
        l2r[0] = nums[0]
        val r2l = IntArray(n)
        r2l[n - 1] = nums[n - 1]
        for (i in 1 until n) l2r[i] = l2r[i - 1] + nums[i]
        for (i in n - 2 downTo 0) r2l[i] = r2l[i + 1] + nums[i]
        for (i in 0 until n) {
            if (l2r[i] == r2l[i]) return i
        }
        return -1
    }
}