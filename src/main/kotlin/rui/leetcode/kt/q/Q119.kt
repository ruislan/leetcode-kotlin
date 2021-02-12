package rui.leetcode.kt.q

class Q119 {
    fun getRow(rowIndex: Int): List<Int> {
        // 方法1
        // 递归思想是一个很重要的思想
        // 是很多算法的基础，是程序思维的开端之一
        // 递归有两个要素，出口和处理
        // 出口也叫基线，通常是最简单的情况，
        //    本题就是当处于第0行的时候（从0开始数行）
        // 处理就是将递归作为一个整体或者处于某个问题的中间过程来看待，
        //    本题就是第N行，我们通过递归得到了N-1行，那么怎么计算第N行
        //    当然是第一个数据为1，然后从1开始迭代N-1行的数据，
        //    两两相加然后放入本行的结果，最后再添加1即可
        // AC 200ms 34.7mb
        if (rowIndex == 0) return mutableListOf(1)
        val list = getRow(rowIndex - 1)
        val answer = mutableListOf(1)
        (1 until list.size).forEach { answer.add(list[it - 1] + list[it]) }
        answer.add(1)
        return answer
    }
}