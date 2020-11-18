package com.dragon.力扣.链表;

public class LC合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        ListNode root = head;
        while(l1!=null&&l2!=null){
            if (l1.val <= l2.val) {
                root.next = l1;
                l1 = l1.next;
            } else {
                root.next = l2;
                l2 = l2.next;
            }
            root = root.next;
        }
        root.next = l1==null?l2:l1;
        return head.next;
    }
}
