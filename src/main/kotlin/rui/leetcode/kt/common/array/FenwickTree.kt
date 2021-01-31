package rui.leetcode.kt.common.array

import rui.leetcode.kt.common.toPrettyString

/**
 * 树状数组
 * 用于解决数组范围内的和的问题
 * 将数据更新和查询时间都变成了o(logn)
 * 例如：[1  2  3  4   5]
 *       1     3      5
 *          3
 *                10
 * 构造树之后得到：[0 1 3 3 10 5]
 */
class FenwickTree(val arr: IntArray) {
    val data: IntArray = IntArray(arr.size + 1)
    var size = data.size

    init {
        for (i in arr.indices) {
            treeUpdate(i + 1, arr[i])
        }
    }

    private fun lowerBit(x: Int): Int = x and -x

    private fun treeUpdate(i: Int, x: Int) {
        var j = i
        while (j < size) {
            data[j] += x
            j += lowerBit(j)
        }
    }

    private fun treeQuery(i: Int): Int {
        var j = i
        var sum = 0
        while (j > 0) {
            sum += data[j]
            j -= lowerBit(j)
        }
        return sum
    }

    fun update(i: Int, x: Int) {
        treeUpdate(i + 1, x - arr[i])
        arr[i] = x
    }

    fun sumOfRange(start: Int, end: Int): Int = treeQuery(end + 1) - treeQuery(start)
}

fun main() {
    val ft = FenwickTree(intArrayOf(1, 2, 3, 4, 5))
    println(ft.data.toPrettyString()) // [0,1 3 3 10 5]
    val rs = ft.sumOfRange(1, 4) // [ 2,3,4,5] = 14
    println(rs) // 14

    ft.update(1, 3) // [1,3,3,4,5]
    println(ft.data.toPrettyString()) // [0,1 4 3 11 5]
}