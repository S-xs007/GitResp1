package com.dragon.力扣.单链表;

public class IntersectNode {

    /**
     *     求链表的第一个入换点,没有就返回空
     */
    public static ListNode isRing(ListNode node){
        //最少三个节点成环
        if(node==null || node.next==null||node.next.next == null){
            return null;
        }
        ListNode fast = node.next.next;
        ListNode slow = node.next;
        //快的走两步，慢的走一步
        while(fast!=slow){
            //如果快节点走到头了还没有，直接返回null，说明不成欢
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = node;
        //相遇之后，慢的继续一个一个走，快的回到头节点也一个一个走
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 返回两个不是环链表的第一个交点，没有就返回null
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode h1 = headA;
        ListNode h2 = headB;
        int n = 0;
        while(h1.next!=null){
                n++;
                h1 = h1.next;

        }
        while(h2.next!=null){
            n--;
            h2 = h2.next;
        }

        if(h1!=h2){
            return null;
        }

            h1 = n>0?headA:headB;   //h1为长
            h2 = h1==headA?headB:headA;//h2为短
            n = Math.abs(n);
            while(n!=0){
                n--;
                h1 = h1.next;
            }

            while (h1!=h2){
                h1 = h1.next;
                h2 = h2.next;
            }
            return h1;

    }

    /**
     * 返回连个都是环的链表的第一个相交的节点，没有就返回空
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode oneNode1(ListNode head1,ListNode head2){
        ListNode ring1 = isRing(head1);
        ListNode ring2 = isRing(head2);
        //第一种情况，在环外相交
        if(ring1==ring2){
            return ring1;
        }
        //第二种情况和第三种情况
        ListNode ring11 = ring1.next;
        ListNode ring22 = ring2.next;
        while(ring11!=ring1){
            ring11 = ring11.next;
            if(ring11==ring2){
                return ring1;
            }
        }
        return null;

    }
    /**
     * 主方法，连个两个链表第一个入环的节点，没有就返回null
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getIntersectNode(ListNode head1,ListNode head2){
        if(head1==null||head2==null){
            return null;
        }
        if(isRing(head1)==null&&isRing(head2)!=null||isRing(head2)==null&&isRing(head1)!=null){
            return null;
        }
        //两个链表都不是环
        if(isRing(head1)==null&&isRing(head2)==null){
            return getIntersectionNode(head1,head2);
            //都是环
        }else if(isRing(head1)!=null&&isRing(head2)!=null){
            if(isRing(head1)==isRing(head2)){
                //同一个节点入换
                return isRing(head1);
            }else{
                //不是同一个节点入换
            }
        }
        return null;
    }
}
