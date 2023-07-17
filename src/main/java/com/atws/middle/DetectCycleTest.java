package com.atws.middle;

/**
 * @author wangshan
 * @date 2023-07-11 下午3:16
 * <p>
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/
 */
public class DetectCycleTest {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//相遇，即有环
                ListNode xiangYuNode = slow;
                ListNode headNode =head;
                while (headNode !=xiangYuNode){
                    headNode = headNode.next;
                    xiangYuNode = xiangYuNode.next;
                }
                return headNode;
            }
        }
        return null;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
