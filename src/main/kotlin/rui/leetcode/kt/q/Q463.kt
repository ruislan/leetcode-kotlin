package rui.leetcode.kt.q

import org.junit.Assert.assertEquals
import org.junit.Test

class Q463 {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        // 方法1
        // 判断每个grid[row][col]的上下左右邻居，如果存在一个邻居，周长少1
        // 需要注意的是第一行、第一列，最后一行、最后一列，邻居可能少1-2，周长多1-2
        // Passed 412ms 56.7mb
        var perimeter = 0
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    var sum = 4
                    if (row > 0) sum -= grid[row - 1][col]  // up
                    if (row < grid.size - 1) sum -= grid[row + 1][col] // down
                    if (col > 0) sum -= grid[row][col - 1] // left
                    if (col < grid[row].size - 1) sum -= grid[row][col + 1]  // right
                    perimeter += sum
                }
            }
        }
        return perimeter
    }

    @Test
    fun test() {
        assertEquals(16,
                islandPerimeter(arrayOf(
                        intArrayOf(0, 1, 0, 0),
                        intArrayOf(1, 1, 1, 0),
                        intArrayOf(0, 1, 0, 0),
                        intArrayOf(1, 1, 0, 0),
                )))
    }
}