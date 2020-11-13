package com.dragon.力扣.单链表;

/**
 * 合并两个有序链表
 */
public class MergeTowList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0), cur = dum;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //直接让剩下的下一个指向
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }
}
