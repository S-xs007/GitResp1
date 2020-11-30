package com.dragon.力扣.栈和队列;

import java.util.Stack;

public class OFFER包含min函数的栈 {
}
class MinStack {

    Stack<Integer> stack, help;
    public MinStack() {
        stack = new Stack<>();
        help = new Stack<>();
    }


    public void push(int x) {
        stack.push(x);
        if(help.isEmpty()||help.peek()>=x){
            help.push(x);
        }else {
            help.push(help.peek());
        }
    }

    public void pop() {
        stack.pop();
        help.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int min() {
        return help.peek();
    }
}
