package com.dragon.力扣.链表;

public class OFFER反转链表 {
    public ListNode reverseList(ListNode head) {
        if(head ==null)return null;
        ListNode pre = null;
        while (head!=null){     //注意细节 最后head是null 要返回pre
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
