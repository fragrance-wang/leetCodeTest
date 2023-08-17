package com.atws.linkedlist;

/**
 * 环形链表 --> 是否有环问题
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 */
public class CycleTest141 {
    public static void main(String[] args) {

    }

    /**
     * 快慢指针，快指针每次走两步，慢指针每次走一步
     * 如果相遇，那么就是有环
     */
    public boolean hasCycle(ListNode head) {
        boolean flag = false;
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                flag = true;
                break;
            }
        }
        return flag;
    }


}
