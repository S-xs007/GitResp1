package com.dragon.力扣.链表;

import java.util.Stack;

public class RingLinkedList {




    /**
     * 判断回文链表(垃圾方法，空间复杂度O（n）)
     * @param head
     * @return
     */
    public boolean isPalindromeNode(ListNode head){
        if(head==null||head.next==null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null){
            if(cur.val!=stack.pop().val){
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /**
     * 空间复杂度比上面的降低了一半（O(n/2)）
     * @param head
     * @return
     */
    public boolean isPalindromeNode02(ListNode head){
        //利用快慢指针找到中点，重点后面的入栈，出栈和链表头部一一比较
        Stack<ListNode> stack = new Stack<>();
        if(head==null||head.next==null){
            return true;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        while(slow!=null){
            stack.push(slow);
            slow = slow.next;
        }
        while(!stack.isEmpty()){
            if(stack.pop().val!=head.val){
                return false;
            }
            head = head.next;
        }
        return true;

    }

    /**
     * 利用快慢指针找到重点（奇数返回中间，偶数返回中上）
     * @param head
     * @return
     */
    public static ListNode midOrUpMidNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode slow = head.next;  //如果都返回前一个这里   ListNode slow = head;
        ListNode fast = head.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 利用快慢指针找到重点（奇数返回中间，偶数返回中下）
     * @param head
     * @return
     */
    public static ListNode midOrDownMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head.next;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }



}
