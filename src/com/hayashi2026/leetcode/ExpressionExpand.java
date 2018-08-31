package com.hayashi2026.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionExpand {

    public static void main(String... args) {
        ExpressionExpand expressionExpand = new ExpressionExpand();
        expressionExpand.expressionExpand("3[abc]");
    }

    /**
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return "";
        }
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> tempList = new ArrayList<>();

        for (char c : charArr) {
            if (c == ']') {
                while (stack.peek() != '[') {
                    tempList.add(stack.pop());
                }
                stack.pop();
                int loopNum = stack.pop();
                for (int j = 0; j < loopNum; j++) {
                    for (int i = tempList.size() - 1; i >= 0; i--) {
                        stack.push(tempList.get(i));
                    }
                }
                tempList.clear();
            } else {
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
