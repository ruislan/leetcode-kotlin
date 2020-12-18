package rui.leetcode.kt.q

class Q389 {
    fun findTheDifference(s: String, t: String): Char {
        // 方法1
        // 通过xor将相同的全部删除即可
        // Passed 180ms 34.5mb
        var diff = 0
        for (x in s) diff = diff xor x.toInt()
        for (x in t) diff = diff xor x.toInt()
        return diff.toChar()
    }
}