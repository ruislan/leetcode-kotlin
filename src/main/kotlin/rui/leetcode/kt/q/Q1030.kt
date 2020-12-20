package rui.leetcode.kt.q

class Q1030 {
    fun allCellsDistOrder(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {
        // 方法1
        // 先求出所有所有坐标到r0,c0的曼哈顿距离，然后按照距离排序
        // Passed 440ms 39.5mb
        val arr = mutableListOf<IntArray>()
        for (row in 0 until R) {
            for (col in 0 until C) {
                val dis = Math.abs(r0 - row) + Math.abs(c0 - col)
                arr.add(intArrayOf(dis, row, col))
            }
        }
        arr.sortBy { it[0] }
        return arr.map { intArrayOf(it[1], it[2]) }.toTypedArray()
    }
}