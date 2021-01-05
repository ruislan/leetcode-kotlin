package rui.leetcode.kt.q

class Q830 {
    fun largeGroupPositions(s: String): List<List<Int>> {
        // 方法1
        // 设置起始位置start为0，然后从位置1开始迭代String的字符
        // 如果s[i] != s[i - 1]，说明连续字符中断，那么
        // 判断当前位置减去start位置是否大于等于3（也即是是否连续三个字符）
        // 如果是，则放入结果数组
        // 需要注意的是在迭代完成之后还要判断一下最后一个字符位置到start是否符合条件
        // Passed 260ms 38.5mb
        val answer = mutableListOf<List<Int>>()
        val n = s.length
        var start = 0
        for (i in 1 until n) {
            if (s[i - 1] != s[i]) {
                if (i - start >= 3) answer.add(listOf(start, i - 1))
                start = i
            }
        }
        if (n - start >= 3) answer.add(listOf(start, n - 1))
        return answer
    }
}