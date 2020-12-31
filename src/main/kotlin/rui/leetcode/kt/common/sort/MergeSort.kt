package rui.leetcode.kt.common.sort

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
fun sort(arr: IntArray, aux: IntArray, lo: Int, hi: Int) {
    if (lo < hi) { // 递归的退出条件
        val mid = lo + ((hi - lo) shr 1)
        sort(arr, aux, lo, mid) // 递归左边合并
        sort(arr, aux, mid + 1, hi) // 递归右边合并
        // 左右都有序了，现在来合并
        // 拷贝元素到辅助数组
        for (i in lo..hi) aux[i] = arr[i]

        var i = lo
        var j = mid + 1
        if (aux[mid] > aux[j]) { // 如果左边的最大比右边的最小还要小，那么就不用归并
            for (k in lo..hi) {
                when {
                    i > mid -> { // 左边空了，取右边
                        arr[k] = aux[j]
                        j += 1
                    }
                    j > hi -> { // 右边空了，取左边
                        arr[k] = aux[i]
                        i += 1
                    }
                    aux[i] >= aux[j] -> { // 左边比右边大，取右边
                        arr[k] = aux[j]
                        j += 1
                    }
                    else -> {
                        arr[k] = aux[i]
                        i += 1
                    }
                }
            }
        }
    }
}

fun IntArray.mergeSort() {
    sort(this, IntArray(size), 0, size - 1)
}