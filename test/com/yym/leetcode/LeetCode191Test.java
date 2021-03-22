package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode191Test {

    @Test
    public void test1() {
        int n = Integer.parseInt("00000000000000000000000000001011", 2);
        assertEquals(3, new LeetCode191().run(n));
    }

    @Test
    public void test2() {
        int n = Integer.parseInt("00000000000000000000000010000000", 2);
        assertEquals(1, new LeetCode191().run(n));
    }

    @Test
    public void test3() {
        StringBuffer s = new StringBuffer("11111111111111111111111111111101");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                s.setCharAt(i, '0');
            } else {
                s.setCharAt(i, '1');
            }
        }
        int n = Integer.parseInt(s.toString(), 2);
        n = -n - 1;
        assertEquals(31, new LeetCode191().run(n));
    }

}