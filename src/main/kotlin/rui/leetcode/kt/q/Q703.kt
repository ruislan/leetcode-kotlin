package rui.leetcode.kt.q

import java.util.*

// 方法1
// 暴力
// AC 1120ms 61.2mb
//class KthLargest(private val k: Int, nums: IntArray) {
//    val arr = nums.toMutableList()
//
//    fun add(`val`: Int): Int {
//        arr.add(`val`)
//        arr.sortDescending()
//        return arr[k]
//    }
//}

// 方法1
// 利用大顶堆（优先级队列），只保存前K个数
// 大于堆顶的，就将堆顶取出，将此数据放入堆
// 小于等于堆顶的，就不需要放进去了
// AC 336ms 50mb
class KthLargest(private val k: Int, nums: IntArray) {
    val heap = PriorityQueue<Int> { a, b -> b.compareTo(a) }

    init {
        nums.forEach { add(it) }
    }

    fun add(x: Int): Int {
        if (heap.size < k) {
            heap.offer(x)
        } else if (x > heap.peek()) {
            heap.poll()
            heap.offer(x)
        }
        return heap.peek()
    }
}