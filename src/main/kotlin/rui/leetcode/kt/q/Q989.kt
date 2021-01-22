package rui.leetcode.kt.q

class Q989 {
    fun addToArrayForm(A: IntArray, K: Int): List<Int> {
        // 方法1
        // 将K转换成数组存储数字
        // 将A翻转，这样位数就对了
        // 然后注意进位就没问题了
        // Passed 424ms 40.3mb
        var x = K
        val B = mutableListOf<Int>()
        while (x > 0) {
            B.add(x % 10)
            x /= 10
        }
        A.reverse()
        var carry = 0
        var i = 0
        var j = 0
        val answer = mutableListOf<Int>()
        while (i < A.size || j < B.size) {
            val a = if (i < A.size) A[i] else 0
            val b = if (j < B.size) B[j] else 0
            val sum = a + b + carry
            carry = sum / 10
            answer.add(sum % 10)
            i += 1
            j += 1
        }
        if (carry > 0) answer.add(carry)
        answer.reverse()
        return answer
    }
}