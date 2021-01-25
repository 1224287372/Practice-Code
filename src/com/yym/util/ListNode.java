package com.yym.util;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    //    快慢指针获取链表中间节点
    public static ListNode middleNode(ListNode head) {
        /*
         *快慢指针，前面是慢指针一次走一个节点，快指针一次走两个节点，
         *直到快指针的后继节点为空。返回慢节点即可。
         * */
        ListNode fastNode = head;
        while (fastNode.next != null && fastNode.next.next != null) {
            head = head.next;
            fastNode = fastNode.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode now = head;
        for (int i = 2; i <= 12; i++) {
            ListNode node = new ListNode(i);
            now.next = node;
            now = node;
            now.next = null;
        }
        now = middleNode(head);
        System.out.println(now.val);
    }
}
