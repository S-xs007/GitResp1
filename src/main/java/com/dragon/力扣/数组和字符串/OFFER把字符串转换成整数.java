package com.dragon.力扣.数组和字符串;

import java.util.HashMap;
import java.util.Map;

public class OFFER把字符串转换成整数 {
    public int strToInt(String str) {
        //1.舍弃开头空格
        char[] s = str.toCharArray();
        int index = 0;
        while(index<s.length){
            if(s[index]==' '){
                index++;
            } else{
                break;
            }
        }
        if(index==s.length){
            return 0;
        }
        //2.判断符号位
        int flag = 1;
        if(s[index]=='-'){
            flag = -1;
            index++;
        }else if (s[index]=='+'){
            index++;
        }
        //3.开始判断数字位
        int res = 0;
        while (index<s.length&&Character.isDigit(s[index])){
            char tem = s[index];
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (tem - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (tem - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res*10+(tem-'0')*flag;
            index++;
        }
        return res;
    }
}
class III{
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
