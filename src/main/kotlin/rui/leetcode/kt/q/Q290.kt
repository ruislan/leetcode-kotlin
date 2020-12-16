package rui.leetcode.kt.q

import org.junit.Test
import kotlin.test.assertEquals

class Q290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        // 方法1
        // 用hashmap将pattern和s的单词对应起来
        // 如果没有出现过，就对应
        // 如果出现过，就看是不是和对应的一致即可
        // Passed 196ms 34.7mb
//        val map = HashMap<Char, String>()
//        val patterns = pattern.toCharArray()
//        val words = s.split(" ")
//
//        if (patterns.size != words.size) return false
//
//        var i = 0
//        while (i < words.size) {
//            val word = map[patterns[i]]
//            if (word != null && word != words[i]) return false
//            if (word == null && map.containsValue(words[i])) return false
//            if (word == null) map[patterns[i]] = words[i]
//            i += 1
//        }
//
//        return true

        // 方法2
        // 双map进行相互映射
        // Passed 188ms 34.7mb
        val map1 = HashMap<Char, String>()
        val map2 = HashMap<String, Char>()
        val patterns = pattern.toCharArray()
        val words = s.split(" ")
        if (patterns.size != words.size) return false

        var i = 0
        while (i < words.size) {
            val word = map1[patterns[i]]
            val pat = map2[words[i]]
            if (word != null && pat != null) {
                if (words[i] != word || pat != patterns[i]) return false
            } else if (word == null && pat != null) {
                return false
            } else if (word != null && pat == null) {
                return false
            } else {
                map1[patterns[i]] = words[i]
                map2[words[i]] = patterns[i]
            }
            i += 1
        }
        return true
    }

    @Test
    fun test() {
        assertEquals(wordPattern("abba", "dog cat cat dog"), true);
        assertEquals(wordPattern("aaaa", "dog cat cat dog"), false);
        assertEquals(wordPattern("abba", "dog dog dog dog"), false)
    }
}