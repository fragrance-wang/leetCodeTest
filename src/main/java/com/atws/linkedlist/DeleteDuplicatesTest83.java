package com.atws.linkedlist;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class DeleteDuplicatesTest83 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4))));
        listNode.print();
        ListNode listNode1 = DeleteDuplicatesTest83.deleteDuplicates(listNode);
        listNode1.print();
    }

    //已经排好序了，直接遍历比较就可以了
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next;
            if (temp.val == next.val) {
                temp.next = next.next;
                next.next = null;
            }else {
                temp = temp.next;
            }
        }
        return head;
    }
}
