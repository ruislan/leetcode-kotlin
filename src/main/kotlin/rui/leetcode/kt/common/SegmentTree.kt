package rui.leetcode.kt.common

/**
 * 线段树
 *
 * 会用到一些堆排序的技巧，复习这个可以和堆排序一起复习
 */
class SegmentTree(private val arr: IntArray) {
    val nodes = IntArray(arr.size * 4)

    init {
        buildTree(0, 0, arr.size - 1)
    }

    fun update(i: Int, value: Int) {
        arr[i] = value
        updateTree(0, 0, arr.size - 1, i)
    }

    fun sumOfRange(l: Int, r: Int) = queryTree(0, 0, arr.size - 1, l, r)

    /**
     * 更新树
     * 找到叶子节点，更新之后，再递归更新该叶子节点的父节点
     */
    private fun updateTree(node: Int, lo: Int, hi: Int, i: Int) {
        if (lo == hi) {
            nodes[node] = arr[i]
        } else {
            val leftChild = node * 2 + 1
            val rightChild = node * 2 + 2
            val mid = lo + ((hi - lo) shr 1)
            if (i <= mid) updateTree(leftChild, lo, mid, i)
            else updateTree(rightChild, mid + 1, hi, i)
            nodes[node] = nodes[leftChild] + nodes[rightChild]
        }
    }

    /**
     * 查询树
     */
    private fun queryTree(node: Int, lo: Int, hi: Int, l: Int, r: Int): Int {
        return if (lo == hi || (lo >= l && hi <= r)) { // 找到了叶子节点或者查找的范围已经被l和r包裹
            nodes[node] // 直接返回节点内容
        } else if (lo > r || hi < l) { // 查找范围已经和l,r的范围没有交集
            0 // 返回0
        } else {
            val leftChild = node * 2 + 1
            val rightChild = node * 2 + 2
            val mid = lo + ((hi - lo) shr 1)
            val leftValue = queryTree(leftChild, lo, mid, l, r)
            val rightValue = queryTree(rightChild, mid + 1, hi, l, r)
            leftValue + rightValue // 返回左右子节点之和
        }
    }

    /**
     * 构造树
     * 这里递归的先构造子树，然后父节点就是子节点的和
     */
    private fun buildTree(node: Int, lo: Int, hi: Int) {
        if (lo == hi) {
            nodes[node] = arr[lo]
        } else {
            val leftChild = node * 2 + 1
            val rightChild = node * 2 + 2
            val mid = lo + ((hi - lo) shr 1)
            buildTree(leftChild, lo, mid)
            buildTree(rightChild, mid + 1, hi)
            nodes[node] = nodes[leftChild] + nodes[rightChild]
        }
    }

}

fun main() {
    val st = SegmentTree(intArrayOf(1, 3, 5, 7, 9, 11))
    println(st.nodes.joinToString(",")) // 36,9,27,4,5,16,11,1,3,0,0,7,9,0,0
    println(st.sumOfRange(2, 5)) // 5+7+9+11=32
    st.update(4, 6) // 1,3,5,7,6,11
    println(st.nodes.joinToString(",")) // 33,9,24,4,5,13,11,1,3,0,0,7,6,0,0
    println(st.sumOfRange(2, 5)) // 5+7+6+11=29
}