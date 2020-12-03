package com.dragon.力扣.链表;

public class OFFER环形链表 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;       //慢的每次走一步
            if (fast.next != null) {
                fast = fast.next.next;  //快的走两步
            } else {
                return null;
            }
            if (fast == slow) {     //相遇了就说明有环
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
