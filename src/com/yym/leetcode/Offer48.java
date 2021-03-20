package com.yym.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Offer48 {
    public int run(String s) {
        return new Solution().lengthOfLongestSubstring(s);
    }

    public int run2(String s) {
        return new Solution().lengthOfLongestSubstring2(s);
    }

    class Solution {
        /**
         * 方法一 双指针
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int i = 0;
            int max = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (map.get(c) == null || map.get(c) == 0) {
                    map.put(c, 1);
                    max = (j - i + 1) > max ? (j - i + 1) : max;
                } else {
                    for (; i < j; i++) {
                        if (c == s.charAt(i)) {
                            i++;
                            break;
                        } else {
                            map.put(s.charAt(i), 0);
                        }
                    }
                }
            }
            return max;
        }

        /**
         * 方法二 动态规划
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            //记录字母的位置
            int[] position = new int[255];
            for (int i = 0; i < 255; i++) {
                position[i] = -1;
            }
            int i = 0, j = 1;
            position[s.charAt(0)] = 0;

            //f(j)代表以j位置字母为结尾的最长子串
            int max = 0, lastLength = 1;
            for (; j < s.length(); j++) {
                int k = position[s.charAt(j)];
                //更新字母的位置
                position[s.charAt(j)] = j;
                //该字母未出现过，则长度加一，即f(j) = f(j-1) + 1
                if (k == -1) {
                    lastLength++;
                } else {
                    int d = j - k;
                    //当前长度d小于f(j-1)，则证明重复的字母没有出现在该最长串中,f(j) = d
                    if (lastLength >= d) {
                        lastLength = d;
                    } else {
                        ///当前长度d大于f(j-1)，则该字母不影响最长串，所以f(j) = f(j-1) + 1
                        lastLength++;
                    }
                }
                max = max > lastLength ? max : lastLength;
            }
            return max;
        }
    }
}

