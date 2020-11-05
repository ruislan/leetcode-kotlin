package rui.leetcode.kt.q

import org.junit.Assert.assertTrue
import org.junit.Test

class Q1356 {
    fun sortByBits(arr: IntArray): IntArray {
        // 方法1
        // 因为数字大小范围在 0 <= arr[i] <= 10^4
        // 创建数组长度10001，统计数字的频率
        // 然后按从小数字到大数字的顺序统计二进制1的个数
        // 最后将32位的数组中的数字取出来进行返回
        // Passed 300ms 38.3mb
//        val freqs = IntArray(10001)
//        arr.forEach { freqs[it] += 1 }
//        val bits = Array<MutableList<Int>>(32) { mutableListOf() }
//        freqs.forEachIndexed { num, freq ->
//            var n = num
//            var countOneBits = 0
//            while (n > 0) {
//                countOneBits += n and 1
//                n = n shr 1
//            }
//            (0 until freq).forEach { _ ->
//                bits[countOneBits].add(num)
//            }
//        }
//        return bits.toList().flatten().toIntArray()

        // 方法2
        // 其实数字少的情况下排序更快，直接统计二进制，然后排序就行了
        // Passed 260ms 38.3mb
        return arr.sortedWith(Comparator { a, b ->
            val o1 = Integer.bitCount(a)
            val o2 = Integer.bitCount(b)
            if (o1 == o2) a.compareTo(b) else o1.compareTo(o2)
        }).toIntArray()
    }

    @Test
    fun test() {
        assertTrue(sortByBits(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)).contentEquals(intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7)))
        assertTrue(sortByBits(intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1)).contentEquals(intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)))
        assertTrue(sortByBits(intArrayOf(10000, 10000)).contentEquals(intArrayOf(10000, 10000)))
        assertTrue(sortByBits(intArrayOf(2, 3, 5, 7, 11, 13, 17, 19)).contentEquals(intArrayOf(2, 3, 5, 17, 7, 11, 13, 19)))
        assertTrue(sortByBits(intArrayOf(10, 100, 1000, 10000)).contentEquals(intArrayOf(10, 100, 10000, 1000)))
        assertTrue(sortByBits(intArrayOf(1111, 7644, 1107, 6978, 8742, 1, 7403, 7694, 9193, 4401, 377, 8641, 5311, 624, 3554, 6631)).contentEquals(intArrayOf(1, 624, 1107, 4401, 8641, 8742, 377, 1111, 6978, 3554, 7694, 9193, 5311, 6631, 7403, 7644)))
    }
}