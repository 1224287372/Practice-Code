package com.yym.leetcode;

import org.junit.Test;

import static org.junit.Assert.*;

public class Offer06Test {
    @Test
    public void test1() {
        Offer06.ListNode node1 = new Offer06.ListNode(1);
        Offer06.ListNode node2 = new Offer06.ListNode(3);
        Offer06.ListNode node3 = new Offer06.ListNode(2);
        node1.next = node2;
        node2.next = node3;

        int[] array = {2, 3, 1};

        assertArrayEquals(array, new Offer06().run(node1));

    }

}