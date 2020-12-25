package rui.leetcode.kt.q

class Q455 {
    fun findContentChildren(g: IntArray, s: IntArray): Int {
        // 方法1
        // 排序g和s
        // 然后双指针i和j，如果 s[j] >= g[i]，则两个指针同时移动
        // 否则，移动j，也即是饼干不匹配当前小孩，需要更高的值
        // Passed 260ms 37.9mb
        g.sort()
        s.sort()
        var i = 0
        var j = 0
        var answer = 0
        while (i < g.size && j < s.size) {
            if (s[j] >= g[i]) {
                answer += 1
                i += 1
            }
            j += 1
        }
        return answer
    }
}