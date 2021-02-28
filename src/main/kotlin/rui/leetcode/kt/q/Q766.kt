package rui.leetcode.kt.q

class Q766 {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        // 方法1
        // 每个单元与其左斜上方的单元比较是否相等即可
        // AC 220ms 37.3mb
        val rows = matrix.size
        val cols = matrix[0].size
        for (row in 1 until rows) {
            for (col in 1 until cols) {
                if (matrix[row][col] != matrix[row - 1][col - 1]) {
                    return false
                }
            }
        }
        return true
    }
}