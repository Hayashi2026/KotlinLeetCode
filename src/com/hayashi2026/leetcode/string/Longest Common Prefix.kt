package com.hayashi2026.leetcode.string

class `Longest Common Prefix` {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val firstStr = strs[0]
        for (i in 0 until firstStr.length) {
            for (str in strs) {
                if (i >= str.length || str[i] != firstStr[i]) {
                    return firstStr.substring(0, i)
                }
            }
        }
        return firstStr
    }
}