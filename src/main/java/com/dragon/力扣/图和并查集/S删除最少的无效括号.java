package com.dragon.力扣.图和并查集;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 有限的回溯
 */
public class S删除最少的无效括号 {

        private Set<String> validExpressions = new HashSet<String>();
        private void recurse(
                String s,
                int index,
                int leftCount,
                int rightCount,
                int leftRem,
                int rightRem,
                StringBuilder expression) {

            // If we reached the end of the string, just check if the resulting expression is
            // valid or not and also if we have removed the total number of left and right
            // parentheses that we should have removed.
            if (index == s.length()) {
                if (leftRem == 0 && rightRem == 0) {
                    this.validExpressions.add(expression.toString());
                }

            } else {
                char character = s.charAt(index);
                int length = expression.length();

                // The discard case. Note that here we have our pruning condition.
                // We don't recurse if the remaining count for that parenthesis is == 0.
                if ((character == '(' && leftRem > 0) || (character == ')' && rightRem > 0)) {
                    this.recurse(
                            s,
                            index + 1,
                            leftCount,
                            rightCount,
                            leftRem - (character == '(' ? 1 : 0),
                            rightRem - (character == ')' ? 1 : 0),
                            expression);
                }

                expression.append(character);

                // Simply recurse one step further if the current character is not a parenthesis.
                if (character != '(' && character != ')') {

                    this.recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);

                } else if (character == '(') {

                    // Consider an opening bracket.
                    this.recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);

                } else if (rightCount < leftCount) {

                    // Consider a closing bracket.
                    this.recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
                }

                // Delete for backtracking.
                expression.deleteCharAt(length);
            }
        }

        public List<String> removeInvalidParentheses(String s) {

            int left = 0, right = 0;

            // First, we find out the number of misplaced left and right parentheses.
            for (int i = 0; i < s.length(); i++) {

                // Simply record the left one.
                if (s.charAt(i) == '(') {
                    left++;
                } else if (s.charAt(i) == ')') {
                    // If we don't have a matching left, then this is a misplaced right, record it.
                    right = left == 0 ? right + 1 : right;

                    // Decrement count of left parentheses because we have found a right
                    // which CAN be a matching one for a left.
                    left = left > 0 ? left - 1 : left;
                }
            }

            this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
            return new ArrayList<String>(this.validExpressions);
        }
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



