package com.yym.leetcode;

public class LeetCode191 {

    public int run(int n) {
        return new Solution().hammingWeight(n);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt("00000000000000000000000000001011", 2);
        int m = Integer.bitCount(n);
        int k = -3;
        int num = 0;
        while (k != 0) {
            if ((k & 1) == 1) {
                num++;
            }
            k = k >>> 1;
        }
        System.out.println(num);
        System.out.println(n);
        System.out.println(m);


        StringBuffer s = new StringBuffer("11111111111111111111111111111101");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                s.setCharAt(i, '0');
            } else {
                s.setCharAt(i, '1');
            }
        }
        int x = Integer.parseInt(s.toString(), 2);
        x = -x - 1;
        System.out.println(x);

    }

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int m = 0;
            while (n != 0) {
                if ((n & 1) == 1) {
                    m++;
                }
                n = n >>> 1;
            }
            return m;
        }
    }
}
