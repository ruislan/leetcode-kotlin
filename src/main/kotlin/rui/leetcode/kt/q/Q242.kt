package rui.leetcode.kt.q

class Q242 {
    fun isAnagram(s: String, t: String): Boolean {
        // 方法1
        // 将s和t自然排序，然后比较即可
        // Passed 236ms 35.2mb Time: O(nlogn)
//        return s.chars().sorted().toArray().contentEquals(t.chars().sorted().toArray())

        // 方法2
        // 因为全小写ascii字母，所以我们用26位数组来存储字母
        // Passed 208ms 35.4mb Time: O(n)
        val bucket = IntArray(26)
        s.chars().forEach { bucket[it - 97] += 1 }
        t.chars().forEach { bucket[it - 97] -= 1 }
        return !bucket.any { it != 0 }
    }
}