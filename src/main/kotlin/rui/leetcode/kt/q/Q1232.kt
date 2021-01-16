package rui.leetcode.kt.q

class Q1232 {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        // 方法一，
        // n点共线问题，利用斜率公式 (y - y0) / (x - x0) = (y - y1) / (x - x1)
        // 因为分母可能为0，所以变形得到 (y - y0) * (x - x1) = (y - y1) * (x - x0)
        // Passed 188ms 37.1mb
        val x0 = coordinates[0][0]
        val y0 = coordinates[0][1]
        val x1 = coordinates[1][0]
        val y1 = coordinates[1][1]
        for (i in 2 until coordinates.size) {
            val x = coordinates[i][0]
            val y = coordinates[i][1]
            if ((y1 - y0) * (x - x0) != (y - y0) * (x1 - x0)) return false
        }
        return true
    }
}