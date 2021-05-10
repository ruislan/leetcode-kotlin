package rui.leetcode.kt.q

class Q872 {
    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        // 方法1
        // 没啥说的，直接把两边的所有子节点都提出来，然后对比就可以了
        // AC 180ms 33.1mb
        fun dfs(node: TreeNode?, v: MutableList<Int>) {
            if (node == null) return
            val left = node.left
            val right = node.right
            if (left == null && right == null) v.add(node.`val`)
            dfs(left, v)
            dfs(right, v)
        }

        val v1 = mutableListOf<Int>()
        val v2 = mutableListOf<Int>()

        dfs(root1, v1)
        dfs(root2, v2)

        return v1 == v2
    }
}