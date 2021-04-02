package rui.leetcode.kt.q

class Q1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        // 方法1
        // 经典dp，最长公共子序列
        // 很多教科书都有这个范例
        // AC 192ms 38.1mb
        val rows = text2.length + 1
        val cols = text1.length + 1
        val dp = Array(rows) { IntArray(cols) }
        for (row in 1 until rows) {
            for (col in 1 until cols) {
                if (text1[col - 1] == text2[row - 1]) {
                    dp[row][col] = 1 + dp[row - 1][col - 1]
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1])
                }
            }
        }
        return dp[rows - 1][cols - 1]
    }
}