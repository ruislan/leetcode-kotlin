package rui.leetcode.kt.q

// 方法1
// 一个栈作为数据存储
// 一个栈作为数据输出
// 当需要peek和pop的时候，首先将数据栈导入输出栈
// 这样一来，输入数据的时候就是O(1)
// 而当没有数据输入的时候，输出只有O(1)
// AC
class MyQueue() {
    private val s1 = java.util.Stack<Int>()
    private val s2 = java.util.Stack<Int>()

    fun push(x: Int) {
        s1.push(x)
    }

    fun pop(): Int {
        move()
        return s2.pop()
    }

    fun peek(): Int {
        move()
        return s2.peek()
    }

    private fun move() {
        if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop())
            }
        }
    }

    fun empty(): Boolean {
        return s1.empty() && s2.empty()
    }
}
