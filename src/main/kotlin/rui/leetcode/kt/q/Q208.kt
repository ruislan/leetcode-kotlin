package rui.leetcode.kt.q

// 方法1
// 这个没啥好说的，就是标准的Trie实现
// 正常来说是用HashMap来实现，如果只有大小写字母，也可以用数组实现，这样计算少一些，不过空间会多一些
// AC 476ms 58mb
class Trie() {
    class Node(
            val ch: Char,
            val children: HashMap<Char, Node> = HashMap(),
            var isWord: Boolean = false
    )

    private val root = Node(' ')

    fun insert(word: String) {
        var node = root
        for (ch in word) {
            if (node.children[ch] == null) node.children[ch] = Node(ch)
            node = node.children[ch]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        for (ch in word) {
            if (node.children[ch] == null) return false
            node = node.children[ch]!!
        }
        return node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        for (ch in prefix) {
            if (node.children[ch] == null) return false
            node = node.children[ch]!!
        }
        return true
    }

}