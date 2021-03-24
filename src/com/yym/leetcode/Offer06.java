package com.yym.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Offer06 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] run(ListNode head) {
        return new Solution().reversePrint(head);
    }

    class Solution {
        public int[] reversePrint(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode lastNode = null;
            while (head != null) {
                list.add(head.val);
                ListNode nextNode = head.next;
                head.next = lastNode;
                head = nextNode;
            }

            int[] array = new int[list.size()];
            for (int i = list.size() - 1; i >= 0; i--) {
                array[i] = list.get(list.size() - i - 1);
            }

            return array;
        }
    }
}
