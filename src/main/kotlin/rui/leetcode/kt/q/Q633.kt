package rui.leetcode.kt.q

class Q633 {

    fun judgeSquareSum(c: Int): Boolean {
        // 方法1
        // 先将所有的平方都存储到hashset中
        // 然后迭代hashset，找另外一个数
        // 如果存在则是答案
        // AC 424ms 43.9mb
//        val set = HashSet<Int>()
//        for (x in 0..c) {
//            val y = x.toLong() * x.toLong()
//            if (y > c) break
//            set.add(y.toInt())
//        }
//        for (x in set) {
//            if (set.contains(c - x)) return true
//        }
//        return false

        // 方法2
        // 利用开方，直接处理
        // AC 156ms
        var x: Long = 0
        while (x * x <= c) {
            val y = Math.sqrt(c.toDouble() - (x * x))
            if (y == Math.ceil(y)) return true
            x += 1
        }
        return false
    }
}