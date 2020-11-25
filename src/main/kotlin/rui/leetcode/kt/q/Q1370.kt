package rui.leetcode.kt.q

class Q1370 {
    fun sortString(s: String): String {
        // 方法1
        // 将字符串按照ASCII顺序放入freq
        // 然后按照顺序、倒序重复直到freq中没有字符
        // Passed 232ms 35.1mb
        val freq = IntArray(26)
        s.chars().forEach { freq[it - 97] += 1 }
        val sb = StringBuilder()
        while (sb.length != s.length) {
            for (i in 0 until 26) {
                if (freq[i] > 0) {
                    sb.append((i + 97).toChar())
                    freq[i] -= 1
                }
            }
            for (i in 25 downTo 0) {
                if (freq[i] > 0) {
                    sb.append((i + 97).toChar())
                    freq[i] -= 1
                }
            }
        }
        return sb.toString()
    }
}