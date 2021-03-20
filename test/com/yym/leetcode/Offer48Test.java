package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Offer48Test {

    @Test
    public void test1() {
        String s = "abcabcbb";
        assertEquals(3, new Offer48().run(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        assertEquals(1, new Offer48().run(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        assertEquals(3, new Offer48().run(s));
    }

    @Test
    public void test4() {
        String s = "";
        assertEquals(0, new Offer48().run(s));
    }

    @Test
    public void test5() {
        String s = "abcabcbb";
        assertEquals(3, new Offer48().run2(s));
    }

    @Test
    public void test6() {
        String s = "bbbbb";
        assertEquals(1, new Offer48().run2(s));
    }

    @Test
    public void test7() {
        String s = "pwwkew";
        assertEquals(3, new Offer48().run2(s));
    }

    @Test
    public void test8() {
        String s = "";
        assertEquals(0, new Offer48().run2(s));
    }

}