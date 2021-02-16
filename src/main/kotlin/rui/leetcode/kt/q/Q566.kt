package rui.leetcode.kt.q

class Q566 {
    fun matrixReshape(nums: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
        // 方法1
        // 将原数组拉平
        // 然后按照row * c + col的方式得到新矩阵的位置，填入数据
        // AC
        val rows = nums.size
        val cols = nums[0].size
        if (r * c != rows * cols) return nums

        val list = nums.flatMap { it.asIterable() }
        val answer = Array(r) { IntArray(c) }
        for (row in 0 until r) {
            for (col in 0 until c) {
                answer[row][col] = list[row * c + col]
            }
        }
        return answer
    }
}