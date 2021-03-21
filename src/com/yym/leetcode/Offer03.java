package com.yym.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Offer03 {

    public int run(int[] nums) {
        return new Solution().findRepeatNumber(nums);
    }

    class Solution {
        /**
         * 空间复杂度O(n)
         *
         * @param nums
         * @return
         */
        public int findRepeatNumber(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int n : nums) {
                if (map.get(n) == null) {
                    map.put(n, 1);
                } else {
                    return n;
                }
            }
            return -1;
        }
    }
}
