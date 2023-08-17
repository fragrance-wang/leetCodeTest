package com.atws.linkedlist;

/**
 * @author wangshan
 * @date 2023-07-11 下午3:16
 * <p>
 *     环形链表2
 * https://leetcode.cn/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/
 */
public class DetectCycleTest142 {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//相遇，即有环
                //相遇以后，只需要让快指针移动到头结点，然后每次只走一步，再次相遇，就是环的头结点
                fast = head;
                while (fast != slow){
                    fast =  fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

}
