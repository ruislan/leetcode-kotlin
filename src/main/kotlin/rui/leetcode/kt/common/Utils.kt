package rui.leetcode.kt.common

fun IntArray.toPrettyString(): String {
    val sb = StringBuilder()
    sb.append('[')
    sb.append(this.joinToString(","))
    sb.append(']')
    return sb.toString()
}

fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[i] xor this[j]
    this[j] = this[i] xor this[j]
    this[i] = this[i] xor this[j]
}

fun <K, V> Map<K, V>.toPrettyString(): String {
    val sb = StringBuilder()
    sb.append('[')
    for ((k, v) in this) {
        sb.append('(').append(k).append(':').append(v).append(')')
        sb.append(',')
    }
    sb.deleteAt(sb.lastIndex)
    sb.append(']')
    return sb.toString()
}