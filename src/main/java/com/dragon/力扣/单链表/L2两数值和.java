package com.dragon.力扣.单链表;

public class L2两数值和 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(1);
        ListNode cur  = head;
        while (l1!=null||l2!=null){
            int ll1 = l1==null?0:l1.val;
            int ll2 = l2==null?0:l2.val;
            int tem = ll1+ll2+carry;
            cur.next = new ListNode(tem%10);
            cur = cur.next;
            carry = tem/10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(carry>0){
            cur.next = new ListNode(carry);
        }
        return head.next;
    }
}
