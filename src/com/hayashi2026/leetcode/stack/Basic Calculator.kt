package com.hayashi2026.leetcode.stack

import java.util.*

class `Basic Calculator` {

    fun calculate(s: String): Int {
        val stack = Stack<Char>()
        for (c in s) {
            when(c) {
                '(', '+', '-' -> {
                    stack.push(c)
                }
                ')' -> {
                    while (stack.peek() != '(') {
                        val right = stack.pop()
                        val op = stack.pop()
                        val left = stack.pop()
                        var res = 0
                        when (op) {
                            '+' -> res = Integer.parseInt(right.toString()) + Integer.parseInt(left.toString())
                            '-' -> res = Integer.parseInt(left.toString()) - Integer.parseInt(right.toString())
                        }
                        if (stack.peek() == '(') {
                            stack.pop()
                        }
                        stack.push(res.toChar())
                    }
                }
                in '0'..'9' -> {

                }

            }
        }

        return stack.pop().toInt()
    }
}

fun main(args: Array<String>) {
    val test = `Basic Calculator`()
    println(test.calculate("1 + 1"))
}