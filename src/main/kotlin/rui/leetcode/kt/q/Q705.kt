package rui.leetcode.kt.q

// 方法1
// 直接创建一个1000001的数组就搞定了
// AC 416ms 54.8mb
class MyHashSet() {
    val data = BooleanArray(1000001)

    fun add(key: Int) {
        data[key] = true
    }

    fun remove(key: Int) {
        data[key] = false
    }

    fun contains(key: Int): Boolean {
        return data[key]
    }

}
