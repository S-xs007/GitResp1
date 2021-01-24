package cn.algorithm.leetcode.栈和队列;


import java.util.Stack;

/**
 * @Author: zxS
 * @Date: 13:08 2020/11/20
 * @Description：利用栈的特性
 */
public class OFFER从尾到头打印链表 {
    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}

