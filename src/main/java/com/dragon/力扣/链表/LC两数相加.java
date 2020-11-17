package com.dragon.力扣.链表;

/**
 * @Author: zxS
 * @Date: 20:08 2020/11/17
 * @Description：两个量表表示两个数，我们需要合成一个新链表（两数的和）
 */
public class LC两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(1);
        ListNode head = result;
        int cal = 0;
        while(l1!=null||l2!=null){
            int x1 = l1==null?0:l1.val;
            int x2 = l2==null?0:l2.val;
            int tem = x1+x2+cal;
            head.next = new ListNode(tem%10);
            cal = tem/10; //进位
            head = head.next;
            if(l1!=null)l1 = l1.next;
            if(l2!=null)l2 = l2.next;
        }
        if(cal>0){
            head.next = new ListNode(cal);
        }
        return result.next;
    }
}
