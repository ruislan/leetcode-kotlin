package rui.leetcode.kt.q

class Q832 {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        // 方法1
        // 题干已经说得很明白了，就是翻转
        // 然后再每个数字（1 - x）或者(x xor 1)就行了
        // 至于写得怎么精简好看，那就是装逼用的了
        // AC 244ms 37.8mb
        for (v in A) {
            val k = v.size - 1
            for (i in 0 until (v.size + 1) / 2) {
                if (i != k - i) {
                    v[i] = v[k - i].also { v[k - i] = v[i] }
                    v[i] = 1 - v[i]
                    v[k - i] = 1 - v[k - i]
                } else {
                    v[i] = 1 - v[i]
                }
            }
        }
        return A
    }
}