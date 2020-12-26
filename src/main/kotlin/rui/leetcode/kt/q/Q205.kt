package rui.leetcode.kt.q

class Q205 {

    fun isIsomorphic(s: String, t: String): Boolean {
        // 方法1
        // 用两个hashmap分别映射彼此的值
        // 如果出现映射不同的情况，则返回失败
        // Passed 208ms 34.6mb
        val a = HashMap<Char, Char>()
        val b = HashMap<Char, Char>()
        for (i in s.indices) {
            if (a[s[i]] == null) a[s[i]] = t[i]
            if (b[t[i]] == null) b[t[i]] = s[i]
            if (a[s[i]] != t[i] || b[t[i]] != s[i]) return false
        }
        return true
    }

}