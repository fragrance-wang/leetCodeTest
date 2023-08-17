package com.atws.linkedlist;

/**
 * 单向链表
 */
public class ListNode {

    public static void main(String[] args) {
        //新建链表实例，用到可以直接拷贝
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    }

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

    public void print() {
        ListNode temp = this;
        StringBuilder stringBuilder = new StringBuilder();
        while (temp != null) {
            stringBuilder.append(temp.val).append("-->");
            temp = temp.next;
        }
        System.out.println(stringBuilder.toString());
    }
}