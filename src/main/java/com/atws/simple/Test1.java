package com.atws.simple;

import java.util.List;
import java.util.Stack;

/**
 * 链表反转
 * @author wangshan
 * @date 2023-07-04 上午11:30
 */
public class Test1 {

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3)));
        Test1 test1 = new Test1();
        ListNode listNode = test1.reverseList(head);
        System.out.println(listNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //递归法-解法
    public ListNode reverseList3(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if(head==null || head.next==null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList3(head.next);
        //这里请配合动画演示理解
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }

    public ListNode reverseList2(ListNode head) {
        // 迭代
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev; // 反转
            prev = cur; // 更新 prev，也就是 prev 前进
            cur = next; // 更新 cur
        }

        return prev;
    }
    public ListNode reverseList1(ListNode head) {

        Stack<Integer> stack = new Stack<Integer>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }
        if (stack.size() == 0){
            return null;
        }
        ListNode result = new ListNode(stack.pop());
        int size = stack.size();
        ListNode lastTemp = result;
        for (int i=0;i<=size-1;i++){
            lastTemp.next = new ListNode(stack.pop());
            lastTemp = lastTemp.next;
        }
        return result;
    }
}
