package com.yym.leetcode;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LeetCode73Test {
    @Test
    public void test1() {
        int[][] matix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] result = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        assertArrayEquals(result, new LeetCode73().run(matix));
    }

    @Test
    public void test2() {
        int[][] matix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        int[][] result = {{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}};
        assertArrayEquals(result, new LeetCode73().run(matix));
    }
}