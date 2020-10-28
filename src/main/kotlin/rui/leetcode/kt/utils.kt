package rui.leetcode.kt

import java.lang.StringBuilder

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