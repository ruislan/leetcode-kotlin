package rui.leetcode.kt.q

// 方法1
// 简单题直接创建一个1000001的数组就好了，不用想太多
// AC 584ms 57.7mb
class MyHashMap() {
    val data = IntArray(1000001) { -1 }

    fun put(key: Int, value: Int) {
        data[key] = value
    }

    fun get(key: Int): Int {
        return data[key]
    }

    fun remove(key: Int) {
        data[key] = -1
    }
}