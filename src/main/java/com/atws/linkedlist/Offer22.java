package com.atws.linkedlist;

/**
 * 剑指Offer 22题
 * 美团：
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始
 * 计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第了个节点是值为4的节点。
 * 解答：
 * ①倒数第k个字节，也就是正数listNode.size()-k+1个索引，所以可以先遍历一次，求出链表长度，将每个链表索引放到map中，
 * 遍历完成后，在根据正数索引位置，从map中获取结果
 * ②双指针法：
 * 先让第一个指针i多走倒数值k-1的距离，然后第二个指针j（从null开始走）和i开始同时向后移动，当i指向null时，说明走完，返回j指针对应的值即可
 * 注意：边界的处理，
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 1;
        k = 5;
        k = 6;
        System.out.println(returnK(listNode, k));
    }

    /**
     * 返回倒数第k个结点的值
     */
    public static Object returnK(ListNode head, int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode i = head;
        ListNode j = null;
        // i沿着链表移动k-1次
        for (int count = 1; count < k; count++) {
            if (i != null)
                i = i.next;
        }
        while (i != null) {
            if (j == null) {
                j = head;
            } else {
                j = j.next;
            }
            i = i.next;
        }
        //完成遍历
        if (j != null) {
            return j.val;
        }

        return null;
    }
}
