package cn.algorithm.leetcode.栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class OFFER队列的最大值 {
}
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> help;

    public MaxQueue() {
        queue = new LinkedList<>();
        help = new LinkedList<>();
    }

    public int max_value() {
        return help.size() > 0 ? help.peek() : -1;
    }

    public void push_back(int value) {
        queue.offer(value);
        while(help.size() > 0 && help.peekLast() < value){
            help.pollLast();
        }
        help.offerLast(value);
    }

    public int pop_front() {
        int head = queue.size() > 0 ? queue.poll() : -1;
        if(help.size() > 0 && help.peek().equals(head)){
            help.poll();    //只有相等help才弹出
        }
        return head;
    }
}
