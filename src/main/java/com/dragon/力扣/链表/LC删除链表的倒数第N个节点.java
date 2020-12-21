package com.dragon.力扣.链表;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LC删除链表的倒数第N个节点 {
    //空间复杂的和时间复杂度都高
    public ListNode removeNthFromEnd(ListNode head, int n) {
        HashMap<Integer,ListNode> map = new HashMap<>();
        ListNode cur = head;
        int index = 0;
        while (cur != null) {
            map.put(++index,cur);
            cur = cur.next;
        }
        index = index-n+1;
        if(map.containsKey(index-1)&&map.containsKey(index+1)){ //都有
            map.get(index-1).next = map.get(index+1);
            return head;
        }else if(map.containsKey(index-1)){     //只有前面的
            map.get(index-1).next = null;
            return head;
        }else if(map.containsKey(index+1)){     //只有后面的
            return map.get(index+1);
        }else{
            return null;
        }
    }
    //利用栈       需要额外空间
    /*public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }*/


    //利用快慢指针  无额外空间
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode first = head;
        ListNode second = root;
        for (int i = 0; i < n; ++i) {   //快节点先走n步
            first = first.next;
        }
        while (first != null) { //然后一起走
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next; //删除
        return root.next;
    }
}
