package rui.leetcode.kt.q

class Q263 {
    fun isUgly(n: Int): Boolean {
        // 方法1
        // 依次将n的2/3/5的因数全部给除掉
        // 剩下的数字，如果是1，那么说明就没其他因数了
        // 否则就说明还有其他因数
        // AC 168ms 32.4mb
        if (n == 0) return false
        var x = n
        while (x and 1 == 0) x /= 2
        while (x % 3 == 0) x /= 3
        while (x % 5 == 0) x /= 5
        return x == 1
    }
}