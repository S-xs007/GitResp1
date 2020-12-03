package com.dragon.力扣.链表;

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

    //方法二，走到头玩会走
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA!=curB){
            curA = curA==null?headB:curA.next;
            curB = curB==null?headA:curB.next;
        }
        return curA;
    }

    }
