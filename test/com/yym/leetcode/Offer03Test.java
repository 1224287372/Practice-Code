package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Offer03Test {

    @Test
    public void test1() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        assertEquals(2, new Offer03().run(nums));
    }
}