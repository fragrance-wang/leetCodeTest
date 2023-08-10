package com.atws.simple;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * <p>
 * <p>
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/12624/intersection-of-two-linked-lists-shuang-zhi-zhen-l/
 * 双指针法 还是很好
 *
 * @author wangshan
 * @date 2023-07-31 17:51
 */
public class GetIntersectionNodeTest {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        GetIntersectionNodeTest test = new GetIntersectionNodeTest();

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
