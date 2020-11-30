package com.dragon.力扣.链表;

import javax.swing.*;
import java.util.Stack;

public class OFFER链表中倒数第K个节点 {

    //利用栈
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head!=null){
            stack.push(head);
            head = head.next;
        }
        ListNode tem = null;
        while(k>0){
            tem = stack.pop();
            k--;
        }
        return tem;
    }
    //利用快慢指针(good)
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while(k>0){
            fast = fast.next;
            k--;
        }
        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
