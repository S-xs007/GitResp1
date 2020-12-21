package com.dragon.力扣.动态规划;

import java.util.Stack;

public class Z逆转栈 {

    public static void reverse(Stack<Integer> stack){
       if(stack.isEmpty())return;
       int tem = f(stack);//得到栈顶元素
       reverse(stack);      //反转
       stack.push(tem);     //把栈顶放进去
    }

    public static int f(Stack<Integer> stack){      //如果只有一个直接返回，还有就返回剩下的
        int re = stack.pop();
        if(stack.isEmpty()){
            return re;
        }else{
            int last = f(stack);
            return last;
        }
    }


}
