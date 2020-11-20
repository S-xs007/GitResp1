package com.dragon.力扣.栈和队列;

import java.util.*;

public class LC移除无效的括号 {
        public String minRemoveToMakeValid(String s) {

            // Parse 1: Remove all invalid ")"
            StringBuilder sb = new StringBuilder();
            int openSeen = 0;   // 左括号的数里
            int balance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(') {
                    openSeen++;
                    balance++;
                } if (c == ')') {
                    if (balance == 0) continue; //如果时无效的就不添加
                    balance--;
                }
                sb.append(c);
            }

            // Parse 2: Remove the rightmost "("
            StringBuilder result = new StringBuilder();
            int openToKeep = openSeen - balance;
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                if (c == '(') {
                    openToKeep--;
                    if (openToKeep < 0) continue;       //删除完了就不添加了
                }
                result.append(c);
            }

            return result.toString();
        }



}
