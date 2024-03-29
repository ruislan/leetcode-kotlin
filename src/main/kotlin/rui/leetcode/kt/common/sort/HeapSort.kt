package rui.leetcode.kt.common.sort

import rui.leetcode.kt.common.swap


/**
 * 堆排序
 * 首先构建大顶堆
 * 然后将数组的堆范围的头数据和尾数据交换
 * 缩减堆范围，直到堆的数据为空
 *
 * 调整堆是核心
 * 首先找到第一个非叶子节点（可以利用(n - 1) / 2 来过滤掉叶子节点）开始调整
 * 然后找到这个子节点的较大的那个，与当前这个交换，然后将交换后的这个作为父节点继续
 * 直到所有的调整都完成（也即是向下调整到叶子节点）
 *
 * 所以每次从堆顶取出数据的时候，都要调整堆
 *
 * O(nlogn)
 */
private fun buildHeap(arr: IntArray) {
    val n = arr.size
    for (i in ((n - 1) shr 1) downTo 0) {
        adjustHeap(arr, i, n)
    }
}

private fun adjustHeap(arr: IntArray, i: Int, n: Int) {
    var father = i
    var child = father * 2 + 1
    while (child < n) {
        if (child + 1 < n && arr[child + 1] > arr[child]) child += 1 // 找到最大的那个子节点
        if (arr[child] < arr[father]) break // 比最大的子节点大，调整结束
        arr.swap(father, child) // 交换父子节点的值
        father = child // 将子节点设置为新的父节点，继续
        child = father * 2 + 1
    }
}

fun IntArray.heapSort() {
    buildHeap(this)
    for (i in size - 1 downTo 1) { // 每次缩小堆范围
        swap(0, i) // 每次交换头和堆范围尾
        adjustHeap(this, 0, i) // 这里只需要调整根节点，其他节点都是符合堆规则的
    }
}
