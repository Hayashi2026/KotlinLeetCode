package com.hayashi2026.leetcode.stack

import java.util.*

class `Valid Parentheses` {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        for (i in 0 until s.length) {
            val char = s[i]
            if (char == ']' || char == '}' || char == ')') {
                if (stack.empty()) {
                    return false
                }
                val top = stack.pop()
                if (char == ']' && top != '[') {
                    return false
                }
                if (char == '}' && top != '{') {
                    return false
                }
                if (char == ')' && top != '(') {
                    return false
                }
            } else {
                stack.push(char)
            }

        }
        return stack.isEmpty()
    }

}