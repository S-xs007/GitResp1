package com.dragon.力扣.图和并查集;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 有限的回溯
 */
public class S删除最少的无效括号 {

}
class Solution1{
    /**
     * 广度优先搜索
     * @param s
     * @return
     */
    public List<String> removeInvalidParentheses1(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        set.add(s);
        while (true) {
            for (String str : set) {
                if (isRegular(str))
                    ans.add(str);
            }
            if (ans.size() > 0) return ans;
            Set<String> nextSet = new HashSet<>();
            for (String str : set) {
                for (int i = 0; i < str.length(); i ++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')')
                        nextSet.add(str.substring(0, i) + str.substring(i + 1, str.length()));
                }
            }
            set = nextSet;
        }
    }

    //判断左右括号是否匹配
    public boolean isRegular(String s) {
        char[] ss = s.toCharArray();
        int count = 0;
        for (char c : ss) {
            if (c == '(') count ++;
            else if (c == ')') count --;
            if (count < 0) return false;
        }
        return count == 0;
    }
}



