package rui.leetcode.kt.q

class Q860 {
    fun lemonadeChange(bills: IntArray): Boolean {
        // 方法1
        // 遇到5元的+1，遇到10元的减去1个5元，加上一个10元
        // 遇到20元的，有10元的，先减去10元，再减去5元，没有10元的，减去3个5元
        // 判断如果5元已经为负，则说明我们不能找零
        // Passed 224ms 37mb
        var five = 0
        var ten = 0
        for (bill in bills) {
            if (bill == 5) {
                five += 1
            } else if (bill == 10) {
                five -= 1
                ten += 1
            } else {
                if (ten > 0) {
                    ten -= 1
                    five -= 1
                } else {
                    five -= 3
                }
            }
            if (five < 0) return false
        }
        return true
    }
}