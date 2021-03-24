package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode456Test {

    @Test
    public void test1() {
        int[] nums = {1, 2, 3, 4};
        assertEquals(false, new LeetCode456().run(nums));
    }

    @Test
    public void test2() {
        int[] nums = {3, 1, 4, 2};
        assertEquals(true, new LeetCode456().run(nums));
    }

    @Test
    public void test3() {
        int[] nums = {-1, 3, 2, 0};
        assertEquals(true, new LeetCode456().run(nums));
    }

    @Test
    public void test4() {
        int[] nums = {-2, 1, 1};
        assertEquals(false, new LeetCode456().run(nums));
    }
}