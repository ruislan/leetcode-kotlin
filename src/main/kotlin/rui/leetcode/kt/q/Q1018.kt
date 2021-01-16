package rui.leetcode.kt.q

class Q1018 {
    fun prefixesDivBy5(A: IntArray): BooleanArray {
        // 方法1
        // 根据题目描述我们要得到下一位则是(x << 1) + a[i]
        // 因为每一次我们之前的数字都要变大2倍
        // 但是由于a的长度会超出整形的存储极限
        // 所以我们需要将数字全部压缩到一个范围内，
        // 这里由于是能够被5所整除，那么就只有0，5结尾的数字可以
        // 也就说说，每次我们都让数字在5以内（5就是0，0就是0）
        // 也就是我们的数字x每次都要x %= 5
        // Passed
        var x = 0
        var answer = BooleanArray(A.size)
        for (i in A.indices) {
            x = ((x shl 1) + A[i]) % 5
            answer[i] = x == 0
        }
        return answer
    }
}