package rui.leetcode.kt.q

class Q925 {
    fun isLongPressedName(name: String, typed: String): Boolean {
        // 将name和typed字符串按照顺序存储到数组a和b中
        // 然后依次比较两个数组，如果b中的字符与a中的字符相等，且数量大于a中的数量，则为true
        // 否则为false
        class MutPair(val ch: Char, var feq: Int)

        val a = mutableListOf<MutPair>()
        val b = mutableListOf<MutPair>()
        a.add(MutPair(name[0], 1))
        b.add(MutPair(typed[0], 1))
        (1 until name.length).forEach { i ->
            if (name[i] != name[i - 1]) a.add(MutPair(name[i], 1))
            else a.last().feq += 1
        }
        (1 until typed.length).forEach { i ->
            if (typed[i] != typed[i - 1]) b.add(MutPair(typed[i], 1))
            else b.last().feq += 1
        }
        if (a.size != b.size) return false
        a.zip(b).forEach {
            if (it.first.ch != it.second.ch) return false
            if (it.first.feq > it.second.feq) return false
        }
        return true
    }
}