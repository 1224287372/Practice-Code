package com.yym.leetcode;

import java.util.Stack;

public class LeetCode456 {

    public boolean run(int[] nums) {
        return new Solution().find132pattern(nums);
    }

    class Solution {
        public boolean find132pattern(int[] nums) {
            int two = Integer.MIN_VALUE;
            Stack<Integer> three = new Stack<>();
            int n = nums.length;
            if (n < 3) {
                return false;
            }
            for (int i = n - 1; i >= 0; i--) {
                int one = nums[i];
                if (one < two) {
                    return true;
                }
                while (!three.isEmpty() && three.peek() < one) {
                    two = three.pop();
                }
                three.push(one);
            }
            return false;
        }
    }
}
