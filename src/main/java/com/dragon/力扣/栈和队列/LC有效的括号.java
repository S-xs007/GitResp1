package com.dragon.力扣.栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: zxS
 * @Date: 14:53 2020/11/18
 * @Description：
 */
public class LC有效的括号 {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        int len = s.length();
        for(int i = 0;i<len;i++){
            char tem = s.charAt(i);
            if(tem==')'){
                if(!isVal(stack,2))return false;
            }else if (tem=='}'){
                if(!isVal(stack,1))return false;
            }else if(tem==']'){
                if(!isVal(stack,3))return false;
            }else {
                stack.push(tem);
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public boolean isVal(Deque<Character> stack,Integer x){
        if(stack.isEmpty())return false;
        if(x==1){
            if(stack.pop()!='{')return false;
        }else if (x==2){
            if(stack.pop()!='(')return false;
        }else {
            if(stack.pop()!='[')return false;
        }
        return true;
    }
}
