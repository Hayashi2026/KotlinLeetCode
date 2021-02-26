import java.util.*


fun main() {
    val test = `Score of Parentheses`()
    println(test.scoreOfParentheses("((((((())))()())))"))
}

class `Score of Parentheses` {

    fun scoreOfParentheses(s: String): Int {
        val stack = Stack<Int>()
        for (element in s) {
            if (element == '(') {
                stack.push(0)
            } else {
                var sum = 0
                while (stack.peek() != 0) {
                    sum += stack.pop()
                }
                stack.pop()
                stack.push(Math.max(sum * 2, 1))
            }
        }
        var res = 0
        while (stack.isNotEmpty()) {
            res += stack.pop()
        }
        return res
    }
}