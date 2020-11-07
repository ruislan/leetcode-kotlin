package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertEquals

class Q122 {
    fun maxProfit(prices: IntArray): Int {
        // 方法1
        // 设置当前的持仓状态hold = false
        //    初始利润profit = 0
        //    购买价格
        // 迭代prices 从1到最后
        //    如果当前价格大于前面的价格 且 未持仓：
        //       用前一个的价格购买
        //       更新持仓状态
        //    如果当前价格小于前面的价格 且 已持仓：
        //       用前一个的价格卖出
        //       更新持仓状态
        //       记录收入利润
        // 迭代结束
        // 如果还处于持仓状态
        //    用最后一个位置的价格卖出
        //    记录收入利润
        // 返回总利润
        // Passed 244ms 40mb
//        var profit = 0
//        var hold = false
//        var buy = 0
//        for (i in 1 until prices.size) {
//            if (prices[i] > prices[i - 1] && !hold) {
//                buy = prices[i - 1]
//                hold = true
//            }
//            if (prices[i] < prices[i - 1] && hold) {
//                profit += prices[i - 1] - buy
//                hold = false
//            }
//        }
//        if (hold) {
//            profit += prices.last() - buy
//        }
//        return profit

        // 方法2
        // 优化方法1
        // 因为获取利润的段始终在上升段，所以我们可以直接将上升段的差值进行累加即可
        // 迭代prices 从1到最后
        //    如果当前价格大于前面的价格
        //       累加当前价格减去前面的价格
        // 返回利润
        // Passed 228ms 36.5mb
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1]
            }
        }
        return profit
    }

    @Test
    fun test() {
        assertEquals(0, maxProfit(intArrayOf(1)))
        assertEquals(1, maxProfit(intArrayOf(1, 2)))
        assertEquals(1, maxProfit(intArrayOf(1, 2, 1)))
        assertEquals(7, maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
        assertEquals(4, maxProfit(intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(0, maxProfit(intArrayOf(7, 6, 4, 3, 1)))
        assertEquals(7, maxProfit(intArrayOf(6, 1, 3, 2, 4, 7)))
    }

}