package cn.algorithm.leetcode.栈和队列;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class LC有效的括号 {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        if(s == null)return true;
        for(char ss:s.toCharArray()){
            if(ss == '(' || ss=='[' || ss=='{')deque.push(ss);
            else if(ss==')'){
                if(deque.size() == 0||deque.pop()!='(')return false;
            }else if(ss==']'){
                if(deque.size() == 0||deque.pop()!='[')return false;
            }else if(ss=='}'){
                if(deque.size() == 0||deque.pop()!='{')return false;
            }
        }
        if(deque.size() == 0)return true;
        return false;
    }
}
