package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertEquals

class Q129 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun sumNumbers(root: TreeNode?): Int {
        // 方法1
        // 将每个节点的临时组成的数据进行存储
        // 广度优先迭代树的每个节点
        // 当到达叶子节点的时候，即可加入求和
        // Passed 192ms 33.7mb
        var sum = 0
        val que = ArrayDeque<TreeNode>()
        if (root != null) que.addLast(root)
        while (que.isNotEmpty()) {
            (0 until que.size).forEach { _ ->
                val node = que.removeFirst()
                if (node.left == null && node.right == null) {
                    sum += node.`val`
                } else {
                    node.left?.let {
                        it.`val` += node.`val` * 10
                        que.addLast(it)
                    }
                    node.right?.let {
                        it.`val` += node.`val` * 10
                        que.addLast(it)
                    }
                }
            }
        }
        return sum
    }

    @Test
    fun test1() {
        val r = TreeNode(1)
        r.left = TreeNode(2)
        r.right = TreeNode(3)
        assertEquals(sumNumbers(r), 25)
    }

    @Test
    fun test2() {
        val r = TreeNode(4)
        r.left = TreeNode(9)
        r.right = TreeNode(0)
        r.left!!.left = TreeNode(5)
        r.left!!.right = TreeNode(1)
        assertEquals(sumNumbers(r), 1026)
    }
}