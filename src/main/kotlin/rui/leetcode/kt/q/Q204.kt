package rui.leetcode.kt.q

class Q204 {
    fun countPrimes(n: Int): Int {
        // 方法1
        // 暴力法，这个一般都会超时，就写一下思路
//        var answer = 0
//        for (x in 2 until n) {
//            var isPrime = true
//            for (i in 2..x / 2) {
//                if (x != i && x % i == 0) {
//                    isPrime = false
//                    break
//                }
//            }
//            if (isPrime) answer += 1
//        }
//        return answer

        // 方法2
        // 用筛法，将当前的数字的2..y倍（小于n）的都标记为不是质数
        // Passed 188ms 33.2mb
        val primes = BooleanArray(n) { true }
        var answer = 0
        for (x in 2 until n) {
            if (primes[x]) {
                answer += 1
                for (y in 2 * x until n step x) {
                    primes[y] = false
                }
            }
        }
        return answer
    }
}