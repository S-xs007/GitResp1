package com.dragon.力扣.链表;

public class LC反转链表 {
    //反转链表1  整个链表的反转
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

    //反转链表2  反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, prev = null;
        while (m > 1) {
            prev = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode newHead = prev, newTail = cur; //

        ListNode third = null;
        while (n > 0) {
            third = cur.next;
            cur.next = prev;
            prev = cur;
            cur = third;
            n--;
        }

        if (newHead != null) {      //判断反转之前有没有节点
            newHead.next = prev;
        } else {
            head = prev;
        }

        newTail.next = cur; // 4->3->2（反转之后的链表） 指向 5
        return head;
    }
}