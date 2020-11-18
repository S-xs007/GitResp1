package com.dragon.力扣.链表;

/**
 * 找重点一定要利用快慢指针
 * 左右归并必须把中间断开
 * 合斌就是谁小，谁拼接在新的数组上
 */
public class P链表排序 {
    //给定链表的头节点，然后把链表排序
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next, slow = head;     //快慢指针找到重点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;   //中间断开

        ListNode left = sortList(head);     //左边排序
        ListNode right = sortList(tmp);     //右边排序

        ListNode h = new ListNode(0);
        ListNode res = h;

        while (left != null && right != null) { //当左右都不为空
            if (left.val < right.val) { //把小的拼接到结果上
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        h.next = left != null ? left : right;       //把剩下的节点拼接上
        return res.next;
    }


    //和上面的一样，就是把合斌给分离出来了
    public ListNode sortList1(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode slow = head; //慢指针
        ListNode fast = head.next; //快指针

        while(fast!=null && fast.next!=null){ //快慢指针找到链表中点
            slow = slow.next; //慢指针走一步
            fast = fast.next.next; //快指针走两步
        }
        ListNode rightHead = slow.next; //链表第二部分的头节点
        slow.next = null; //cut 链表

        ListNode left = sortList(head); //递归排序前一段链表
        ListNode right = sortList(rightHead); //递归排序后一段链表
        return merge(left,right);
    }
    public ListNode merge(ListNode h1,ListNode h2){ //合并两个有序链表
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while(h1!=null && h2!=null){
            if(h1.val < h2.val){
                p.next = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        if(h1!=null)    p.next = h1;
        else if(h2!=null) p.next = h2;
        return dummy.next;

    }

}




