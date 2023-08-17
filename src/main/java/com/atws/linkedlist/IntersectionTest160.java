package com.atws.linkedlist;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 相交链表
 * @author wangshan
 * @date 2023-07-12 上午10:43
 */
public class IntersectionTest160 {
    public static void main(String[] args) {

    }

    /**
     * A走到结尾的时候 从链表B的头部位置开始走
     * B走到结尾的时候，从链表A的头部位置开始走
     * a==b的位置，即为交点
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        //如果没有交点，那么最后 a == b ,都是null
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
