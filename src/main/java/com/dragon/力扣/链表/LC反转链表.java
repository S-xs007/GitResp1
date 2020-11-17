package com.dragon.力扣.链表;

public class LC反转链表 {
    public ListNode reverseList(ListNode head) {
        ListNode next = null;
        ListNode pre =null;
        while(head!=null){
            next = head.next;   //记录下一个
            head.next = pre;       //下一个向前指
            pre = head;         //前一个向后走
            head = next;        //头节点向后走
        }
        return pre;
    }
}
