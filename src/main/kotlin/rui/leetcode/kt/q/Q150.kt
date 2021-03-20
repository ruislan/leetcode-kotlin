package rui.leetcode.kt.q

import java.util.*

class Q150 {
    fun evalRPN(tokens: Array<String>): Int {
        // 方法1
        // 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
        // 遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。
        // AC 196ms 35mb
        val stack = Stack<Int>()
        for (i in tokens.indices) {
            val token = tokens[i];
            when (token) {
                "+" -> stack.push(stack.pop() + stack.pop())
                "*" -> stack.push(stack.pop() * stack.pop())
                "-" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push(a - b)
                }
                "/" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push(a / b)
                }
                else -> {
                    stack.push(Integer.parseInt(token))
                }
            }
        }
        return stack.pop()
    }
}