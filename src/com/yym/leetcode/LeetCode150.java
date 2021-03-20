package com.yym.leetcode;

import org.junit.Test;

import java.util.Stack;

public class LeetCode150 {
    public static void main(String[] args) {
        System.out.println();
    }

    public int run(String[] tokens) {
        return new Solution().evalRPN(tokens);
    }

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String s : tokens) {
                switch (s) {
                    case "/":
                        Integer m2 = stack.pop();
                        Integer m1 = stack.pop();
                        stack.push(m1 / m2);
                        break;
                    case "*":
                        m2 = stack.pop();
                        m1 = stack.pop();
                        stack.push(m1 * m2);
                        break;
                    case "+":
                        m2 = stack.pop();
                        m1 = stack.pop();
                        stack.push(m1 + m2);
                        break;
                    case "-":
                        m2 = stack.pop();
                        m1 = stack.pop();
                        stack.push(m1 - m2);
                        break;
                    default:
                        Integer number = Integer.parseInt(s);
                        //System.out.println(number);
                        stack.push(number);
                        break;
                }
            }
            Integer now = stack.pop();
            return now;
        }
    }

}
