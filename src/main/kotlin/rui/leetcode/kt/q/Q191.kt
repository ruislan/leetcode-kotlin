package rui.leetcode.kt.q

class Q191 {
    fun hammingWeight(n: Int): Int {
        // 方法1
        // 关键就是用ushr做无符号移位
        // AC 168ms 32.3mb
        var x = n
        var ones = 0
        while (x != 0) {
            ones += x and 1
            x = x ushr 1
        }
        return ones
    }
}