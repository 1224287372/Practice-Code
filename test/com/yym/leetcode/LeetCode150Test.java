package com.yym.leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeetCode150Test {

    @Test
    public void test1() {
        String[] tokens = {"2", "1", "+", "3", "*"};
        assertEquals(9, new LeetCode150().run(tokens));
    }

    @Test
    public void test2() {
        String[] tokens = {"4", "13", "5", "/", "+"};
        assertEquals(6, new LeetCode150().run(tokens));
    }

    @Test
    public void test3() {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        assertEquals(22, new LeetCode150().run(tokens));
    }

    @Test
    public void test4() {
        String[] tokens = {"18"};
        assertEquals(18, new LeetCode150().run(tokens));
    }

    @Test
    public void test5() {
        String[] tokens = {"3", "11", "+", "5", "-"};
        assertEquals(9, new LeetCode150().run(tokens));
    }

    @Test
    public void test6() {
        String[] tokens = {"3", "11", "5", "+", "-"};
        assertEquals(-13, new LeetCode150().run(tokens));
    }

}
