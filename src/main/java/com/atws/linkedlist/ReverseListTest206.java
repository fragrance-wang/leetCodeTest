package com.atws.linkedlist;

/**
 * 反转链表
 */
public class ReverseListTest206 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));
        listNode.print();
        reverseList(listNode).print();
    }

    /**
     * 画图做是最方便的，逻辑最清晰
     * 本质上是建一个pre=null的空指针，
     * 双指针移动
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
