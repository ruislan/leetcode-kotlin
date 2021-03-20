package rui.leetcode.kt.q

class Q1047 {
    fun removeDuplicates(s: String): String {
        // 方法1
        // 利用栈的后进先出思想解决这个问题很简单
        // AC 284ms 35.3mb
        val sb = StringBuilder()
        for (ch in s) {
            if (sb.isNotEmpty() && sb.last() == ch) {
                sb.deleteCharAt(sb.lastIndex)
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()
    }

}