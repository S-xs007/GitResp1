package com.dragon.力扣.数组和字符串;

import java.util.HashMap;
import java.util.Map;

public class Z字符串转换证书 {
    //绝妙的自动机
        public int myAtoi(String str) {
            Automaton automaton = new Automaton();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                automaton.get(str.charAt(i));
            }
            return (int) (automaton.sign * automaton.ans);
        }
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {        //如果是数字，就计算结果
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {        //如果是+-就 更新正负
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {     //空格是0
                return 0;
            }
            if (c == '+' || c == '-') { //+-是1
                return 1;
            }
            if (Character.isDigit(c)) { //数字是2
                return 2;
            }
            return 3;   //其他是3
        }

}
class Solution1 {

    public int myAtoi(String s) {
        int len = s.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = s.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String str = "2147483646";
        int res = solution.myAtoi(str);
        System.out.println(res);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }


















    //自己写的
    public int myAtoi1(String s) {
        int len = s.length();
        char[] nums = s.toCharArray();
        int index = 0;
        while(index<len&&nums[index]==' '){    //去除前面的空格
            index++;
        }
        if(index==s.length())return 0;
        int i = 1;
        if(nums[index]=='-'){
            i = -1;
            index++;
        }else if(nums[index]=='+'){
            index++;
        }
        int result = 0;
        while(index<len){
            char x = nums[index];
            if(x>'9'||x<'0')break;
            if(result>Integer.MAX_VALUE/10||(result==Integer.MAX_VALUE/10&&(x - '0') > Integer.MAX_VALUE % 10))return Integer.MAX_VALUE;
            if(result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && (x - '0') > -(Integer.MIN_VALUE % 10)))return Integer.MIN_VALUE;
            result = result*10 + i*(x-'0');
            index++;
        }
        return result;

    }
}
