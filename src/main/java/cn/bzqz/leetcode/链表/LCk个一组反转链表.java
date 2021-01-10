package cn.bzqz.leetcode.链表;

import cn.bzqz.leetcode.二叉树.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.List;

public class LCk个一组反转链表 {

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
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        while(m>1){
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode oldTail = pre;
        ListNode newTail = cur;
        ListNode next = null;
        while(n>0){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            n--;
        }
        if(oldTail!=null){
            oldTail.next = pre;
        }else{
            head = pre;
        }
        newTail.next = cur;
        return head;
    }
    //
    //反转链表三
    //在前面接一个hair
    //
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode hair = new ListNode(0);
            hair.next = head;
            ListNode pre = hair;

            while (head != null) {
                ListNode tail = pre;
                // 查看剩余部分长度是否大于等于 k
                for (int i = 0; i < k; ++i) {
                    tail = tail.next;
                    if (tail == null) {
                        return hair.next;
                    }
                }
                //----------------------------
                ListNode nex = tail.next;   //记录下一段的头节点
                ListNode[] reverse = myReverse(head, tail);//反转
                head = reverse[0];
                tail = reverse[1];
                // 把子链表重新接回原链表
                pre.next = head;
                tail.next = nex;
                pre = tail;
                head = tail.next;
            }

            return hair.next;
        }

        public ListNode[] myReverse(ListNode head, ListNode tail) {
            ListNode prev = tail.next;
            ListNode cur = head;
            while (prev != tail) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return new ListNode[]{tail, head};
        }
}
