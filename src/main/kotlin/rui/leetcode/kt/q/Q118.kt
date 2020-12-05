package rui.leetcode.kt.q

class Q118 {
    fun generate(numRows: Int): List<List<Int>> {
        // Passed 188ms 34.3mb
        val answer = mutableListOf<List<Int>>()
        for (row in 0 until numRows) {
            if (row == 0) {
                answer.add(listOf(1))
            } else {
                val arr = mutableListOf(1)
                for (col in 1 until row - 1) {
                    arr.add(answer[row - 1][col - 1] + answer[row - 1][col])
                }
                arr.add(1)
                answer.add(arr)
            }
        }
        return answer
    }
}