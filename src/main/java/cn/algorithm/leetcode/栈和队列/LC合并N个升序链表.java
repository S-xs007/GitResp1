package cn.algorithm.leetcode.栈和队列;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC合并N个升序链表 {
    //先来一个简单的，合并两个升序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode head = new ListNode(1);
        ListNode tail = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                tail.next = l1;
                l1= l1.next;
            }else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l2!=null)tail.next = l2;
        if (l1!=null)tail.next = l1;
        return head.next;

    }
    //合并N个有序链表
    //1.方式1，分治
    public ListNode mergeKLists(ListNode[] lists) {
        int l = 0;
        int r = lists.length-1;
        return guibing(lists,l,r);
    }

    private ListNode guibing(ListNode[] lists, int l, int r) {
        if(l == r)return lists[l];
        if (l > r) {
            return null;
        }
        int mid = (l+r)>>1;
        ListNode left = guibing(lists,l,mid);
        ListNode right = guibing(lists,mid+1,r);
        return mergeTwoLists(left,right);
    }

    //方法2.利用优先队列
    public ListNode mergeKLists2(ListNode[] lists) {
        //按照链表的头节点递增
        //小根堆
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node : lists){
            if(node!=null){
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!q.isEmpty()){
            tail.next = q.poll();
            tail = tail.next;
            if (tail.next != null){
                q.add(tail.next);
            }
        }
        return head.next;
    }
}
