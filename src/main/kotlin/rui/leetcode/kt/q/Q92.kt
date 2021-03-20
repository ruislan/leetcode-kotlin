package rui.leetcode.kt.q

class Q92 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
        // 方法1
        // 只有一次遍历，那么我们只要进入了翻转区域[m..n]，就开始执行翻转
        // 然后翻转完成之后，把最后的接上去就可以了
        // 这里我们使用了一个dummy head来作为遍历时的暂存连接点
        // AC 160ms 32.mb
        val dm: ListNode? = ListNode(0)
        dm?.next = head
        var node = dm
        var rev: ListNode? = null
        var i = 1
        while (node?.next != null) {
            if (i == m) rev = node?.next
            if (i in m until n) {
                val next = rev?.next
                rev?.next = rev?.next?.next
                next?.next = node?.next
                node?.next = next
            } else {
                node = node?.next
            }
            i += 1
        }
        return dm?.next
    }
}