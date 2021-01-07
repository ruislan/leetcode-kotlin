package rui.leetcode.kt.common.sort

import rui.leetcode.kt.common.swap

/**
 * 快速排序
 *
 * 时间复杂度O(nlogn)
 */
private fun sort(arr: IntArray, lo: Int, hi: Int) {
    if (lo < hi) {
        val pivot = partition(arr, lo, hi)
        sort(arr, lo, pivot)
        sort(arr, pivot + 1, hi)
    }
}

/**
 * 切分数组
 * 这里我们选择以范围内的中间值来进行切分
 * 而不是以第一个值来切分，这样避免最后还要交换第一个值到正确的位置上
 */
private fun partition(arr: IntArray, lo: Int, hi: Int): Int {
    val x = arr[lo + ((hi - lo) shr 1)]
    var i = lo
    var j = hi
    while (true) {
        while (arr[i] < x) i += 1
        while (arr[j] > x) j -= 1
        if (i >= j) return j
        arr.swap(i, j)
        i += 1
        j -= 1
    }
}

fun IntArray.quickSort() {
    sort(this, 0, size - 1)
}