package com.atws.middle;

import java.util.List;

/**
 * @author wangshan
 * @date 2023-07-12 下午2:22
 */
public class RemoveNthFromEndTest {
    public static void main(String[] args) {

        ListNode listNode = new RemoveNthFromEndTest().removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
        System.out.println(listNode);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n >= 1) {
            return null;
        }

        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < n; i++) {
            a = a.next;
        }

        if (a == null) {
            head = head.next;
            return head;
        }
        while (a.next != null) {
            a = a.next;
            b = b.next;
        }
        ListNode nNode = b.next;
        ListNode nNextNode = b.next.next;
        nNode.next = null;
        b.next = nNextNode;
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
