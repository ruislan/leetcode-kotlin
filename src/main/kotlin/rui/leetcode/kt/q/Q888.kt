package rui.leetcode.kt.q

class Q888 {
    fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
        // 方法1
        // 求出A，B两边各自的和，A，B的平均数avg
        // 迭代A，当A少掉一个数之后，它需要增加一个数成为平均值
        // 而增加的这个数如果在B中能够找到，那么就是要更换的
        // AC 400ms 38.5mb
        val sumA = A.sum()
        val sumB = B.sum()
        val avg = (sumA + sumB) shr 1
        val setB = HashSet<Int>()
        for (i in B.indices) setB.add(B[i])
        for (i in A.indices) {
            val need = avg - (sumA - A[i])
            if (setB.contains(need)) return intArrayOf(A[i], need)
        }
        return intArrayOf()
    }
}