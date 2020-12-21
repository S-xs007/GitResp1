package com.dragon.力扣.链表;

import java.util.List;
import java.util.Stack;

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


    //两数相加2
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int curVal = a + b + carry;
            carry = curVal / 10;
            curVal %= 10;
            ListNode curnode = new ListNode(curVal);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }


}
