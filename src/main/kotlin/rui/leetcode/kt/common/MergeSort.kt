package rui.leetcode.kt.common

/**
 * 合并排序
 *
 * 核心思想：
 * 将数组分离成两个，然后各自再分离成两个
 * 直到最后只剩下1个或者2个元素，直接比较即可
 *
 * 注意点：
 * 需要合并两个数组a和b，合并的时候需要一个辅助数组aux
 *    i从0 until aux.size
 *    如果a已经没有元素了，放入b
 *    如果b已经没有元素了，放入a
 *    如果a[i] >= b[i]，放入b[i]
 *    否则a[i] < b[i]，放入a[i]
 **/

fun merge(arr: IntArray, lo: Int, hi: Int) {

}

fun sort(arr: IntArray) {

}