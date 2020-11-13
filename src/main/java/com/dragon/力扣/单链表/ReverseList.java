package com.dragon.力扣.单链表;

/**
 * 链表反转
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode root = head;
        ListNode next = null;
        ListNode pre = null;
        while(root!=null){
            next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }
}
