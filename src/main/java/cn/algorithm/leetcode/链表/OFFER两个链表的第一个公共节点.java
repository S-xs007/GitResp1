package cn.algorithm.leetcode.链表;

import java.util.HashSet;
import java.util.Set;

public class OFFER两个链表的第一个公共节点 {
    //方法1先判断长度，让长的先走
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cha = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=null){
            cha++;
            curA = curA.next;
        }
        while (curB!=null){
            cha--;
            curB = curB.next;
        }
        while (cha>0){
            headA = headA.next;
            cha--;
        }
        while (cha<0){
            headB = headB.next;
            cha++;
        }
        while(headA!=headB){
            //if(headA==null||headB==null)return null;
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    //方法二，走到头往回走
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //创建集合set
        Set<ListNode> set = new HashSet<>();
        //先把链表A的结点全部存放到集合set中
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        //然后访问链表B的结点，判断集合中是否包含链表B的结点，如果包含就直接返回
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        //如果集合set不包含链表B的任何一个结点，说明他们没有交点，直接返回null
        return null;
    }

    }
