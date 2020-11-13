package com.dragon.力扣.动态规划;

import java.util.Stack;

public class Z逆转栈 {

    public static void reverse(Stack<Integer> stack){
       if(stack.isEmpty())return;
       int tem = f(stack);
       reverse(stack);
       stack.push(tem);
    }

    public static int f(Stack<Integer> stack){
        int re = stack.pop();
        if(stack.isEmpty()){
            return re;
        }else{
            int last = f(stack);
            return last;
        }
    }


}
