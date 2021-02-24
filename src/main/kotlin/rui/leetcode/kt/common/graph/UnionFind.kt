package rui.leetcode.kt.common.graph

class UnionFind(val n: Int) {
    val parent = (0 until n).map { it }.toIntArray()
    val rank = IntArray(n)
    val sz = IntArray(n) { 1 }
    var setCount = n

    fun find(x: Int): Int {
        if (x != parent[x]) parent[x] = find(parent[x])
        return parent[x]
    }

    fun unite(x: Int, y: Int): Boolean {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return false
        when {
            rank[rootX] > rank[rootY] -> {
                parent[rootY] = parent[rootX]
                sz[rootX] += sz[rootY]
            }
            rank[rootX] < rank[rootY] -> {
                parent[rootX] = parent[rootY]
                sz[rootY] += sz[rootX]
            }
            else -> {
                parent[rootY] = parent[rootX]
                sz[rootX] += sz[rootY]
                rank[rootX] += 1
            }
        }
        setCount -= 1
        return true
    }
}