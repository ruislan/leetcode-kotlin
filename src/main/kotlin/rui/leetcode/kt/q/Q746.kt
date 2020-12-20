package rui.leetcode.kt.q

class Q746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        // 方法1
        // 动态规划
        // 起点是前两个
        // 当前阶梯的花费是前1个或者再前1个的阶梯花费中最小的那个 + 自己
        // 最后的结果是倒数两个中最小的那个
        // Passed 220ms 35.3MB
        val n = cost.size
        val dp = IntArray(n)
        dp[0] = cost[0]
        dp[1] = cost[1]
        for (i in 2 until n) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2])
        }
        return Math.min(dp[n - 1], dp[n - 2])
    }
}