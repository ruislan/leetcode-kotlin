package rui.leetcode.kt.q

class Q509 {
    fun fib(n: Int): Int {
        // 方法1
        // 最简单的就是递归了f(n) = f(n - 1) + f(n - 2)，当然如果数据较大效率较低

        // 方法2
        // 通过f(n) = f(n - 1) + f(n - 2)可以知道
        // f(n - 1) = f(n - 2) + f(n - 3)……
        // 观察得到f(x)会被多次计算，例如f(n - 2)在f(n)和f(n-1)都有计算
        // 所以用hashmap来存储f(x)的值，这样可以节约多次计算

        // 方法3
        // 直接用a，b存储前两个值
        // 在每次计算之后移动新的数据到a,b
        // Passed 124ms 31.9mb
        if (n <= 1) return n
        var a = 0
        var b = 1
        for (i in 2..n) a = b.also { b += a }
        return b
    }
}