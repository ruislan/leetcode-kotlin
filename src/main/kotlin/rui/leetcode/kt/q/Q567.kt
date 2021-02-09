package rui.leetcode.kt.q

class Q567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        // 方法1
        // 将s1看成s2中固定长度的窗口
        // 滑动窗口，看窗口内的字符串频率是否相等即可，O(26*n)
        // AC 196ms 34.8mb
        if (s1.length > s2.length) return false
        val k = s1.length
        val freq = IntArray(26)
        for (ch in s1) freq[ch.toInt() - 97] += 1
        val windowFreq = IntArray(26)
        for (i in 0 until k) {
            windowFreq[s2[i].toInt() - 97] += 1
        }
        if (windowFreq.contentEquals(freq)) return true
        for (i in k until s2.length) {
            windowFreq[s2[i - k].toInt() - 97] -= 1
            windowFreq[s2[i].toInt() - 97] += 1
            if (windowFreq.contentEquals(freq)) return true
        }
        return false
    }
}