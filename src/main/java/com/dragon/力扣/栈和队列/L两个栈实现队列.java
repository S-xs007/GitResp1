package com.dragon.力扣.栈和队列;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class L两个栈实现队列 {


}
class CQueue {
    Deque<Integer> push;
    Deque<Integer> pop;
    public CQueue() {
        push = new LinkedList<Integer>();
        pop = new LinkedList<Integer>();

    }
    //添加节点
    public void appendTail(int value) {
        push.push(value);
    }

    public int deleteHead() {
        if(!pop.isEmpty()){ //pop不为空直接弹出
            return (int) pop.pop();
        }else {
            if(!push.isEmpty()){        //push不空就转移
                pushToPop();
                return (int) pop.pop();
            }else{
                return -1;
            }
        }
    }

    public void pushToPop(){
        if(pop.isEmpty()){
            while(!push.isEmpty())
            pop.push(push.pop());
        }
    }
}