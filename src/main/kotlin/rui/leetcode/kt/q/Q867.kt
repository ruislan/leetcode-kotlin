package rui.leetcode.kt.q

class Q867 {
    fun transpose(matrix: Array<IntArray>): Array<IntArray> {
        // 方法1
        // 按照题意创建一个rows变成cols，cols变成rows的新矩阵
        // 按照matrix[row][col] = newMatrix[col][row]
        // 的方式转换就行了
        // AC 244ms 36.2mb
        val rows = matrix.size
        val cols = matrix[0].size
        val answer = Array(cols) { IntArray(rows) }
        for (i in 0 until rows) {
            for (j in 0 until cols) {
                answer[j][i] = matrix[i][j]
            }
        }
        return answer
    }
}