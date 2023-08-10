package com.atws.simple;

/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/description/
 * 合并两个有序链表
 * @author wangshan
 * @date 2023-07-31 17:31
 */
public class MergeTwoListsTest {

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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        MergeTwoListsTest mergeTwoListsTest = new MergeTwoListsTest();
        ListNode listNode = mergeTwoListsTest.mergeTwoLists(listNode1, listNode2);
        listNode.print();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode listNode = new ListNode(-1);
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode temp = listNode;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            }else {
                temp.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }

        if (temp1!=null){
            temp.next = temp1;
        }
        if (temp2!=null){
            temp.next = temp2;
        }
        return listNode.next;
    }
}
