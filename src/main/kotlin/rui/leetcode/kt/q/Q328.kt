package rui.leetcode.kt.q


class Q328 {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        // 方法1
        // 创建三个指针p0 = head，p1 = head.next, p_even = head.next
        // 然后依次以下处理：
        //     让p0.next = p1.next，这样1位置和3位置便联通起来，
        //     然后p0 = p0.next，这样p0指向的便是3位置
        //     让p1.next = p0.next，这样2位置和4位置便联通起来，
        //     然后p1 = p1.next，这样p1指向的便是4位置
        // 直到所有的节点都指向了NULL
        // 然后将p0.next = p_even
        // 最后返回head
        // Passed 220ms 34.3mb
        var p0 = head
        var p1 = head?.next
        if (p0 == null || p1 == null) return head
        val pEven = p0.next
        while (p0 != null && p1 != null) {
            p0.next = p1.next
            if (p0.next != null) p0 = p0.next
            p1.next = p0?.next
            p1 = p1.next
        }
        p0?.next = pEven
        return head
    }
}