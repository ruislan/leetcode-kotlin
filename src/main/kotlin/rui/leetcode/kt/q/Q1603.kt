package rui.leetcode.kt.q

// 方法1
// 这个题就没啥好说的了吧
// 可以排进LeetCode最简单的5个题之一了吧
// AC 304ms 42.8mb
class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val park = intArrayOf(0, big, medium, small)

    fun addCar(carType: Int): Boolean = park[carType]-- > 0
}