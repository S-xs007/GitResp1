package cn.algorithm.leetcode.栈和队列;

import java.util.LinkedList;
import java.util.Queue;

public class L两个队列实现栈 {
}

class MyStack {
    Queue<Integer> queue;
    Queue<Integer> help;

    public MyStack() {
        queue = new LinkedList<Integer>();
        help = new LinkedList<Integer>();
    }
    //放到辅助队列，然后把主队列全部转移到辅助队列，然后换角色
    public void push(int x) {
        help.offer(x);
        while (!queue.isEmpty()) { //把1全部转移到2
            help.offer(queue.poll());
        }
        Queue<Integer> temp = queue;   //角色转换
        queue = help;
        help = temp;
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
