package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Offer04Test {
    @Test
    public void test1() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        assertEquals(true, new Offer04().run(matrix, 5));
    }

    @Test
    public void test2() {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        assertEquals(false, new Offer04().run(matrix, 20));
    }

    @Test
    public void test3() {
        int[][] matrix = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        assertEquals(true, new Offer04().run(matrix, 19));
    }
}