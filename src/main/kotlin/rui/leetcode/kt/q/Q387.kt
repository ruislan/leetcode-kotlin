package rui.leetcode.kt.q

class Q387 {
    fun firstUniqChar(s: String): Int {
        // 方法1
        // 遇事不决，就上hashmap
        // Passed 324ms 35.1mb
        val map = HashMap<Char, Int>()
        for (x in s) {
            if (map[x] == null) map[x] = 0
            map[x] = map[x]!! + 1
        }
        for (i in s.indices) {
            if (map[s[i]] == 1) return i
        }
        return -1
    }
}