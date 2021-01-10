package com.rocketmq;

import com.dragon.力扣.链表.ListNode;

import java.util.*;

public class StrTest {
    public static Map<String,List<String>> str(int[] num,String str){
        int index = 0;
        StringBuilder keyWord = new StringBuilder();
        StringBuilder word = new StringBuilder();
        Map<String,List<String>> res = new HashMap<>();
        for(int i = 0;i<num.length;i++){
            if(num[i] == 0)continue;
            if(num[i] == 1 || num[i] == 2){
                keyWord.append(str.charAt(i));
                if(num[i+1]!=2){
                    res.computeIfAbsent("关键字",k->new LinkedList<>()).add(keyWord.toString());
                    keyWord = new StringBuilder();
                }
            }
            if(num[i] == 3 || num[i] == 4){
                word.append(str.charAt(i));
                if(i+1 >=num.length || num[i+1]!=4){
                    res.computeIfAbsent("串",k->new LinkedList<>()).add(word.toString());
                    word = new StringBuilder();
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,0,3,4,4,4,4,4,4,4,4,4,4,4,4,0,0,1,2,0,3,4,4,4,4,4,4,4,4,4,4};
        String s = "想知道如果提高王者荣耀水平，上分把妹不是梦，加微信：17252sugats78，加QQ：34676328889";
        Map<String,List<String>> map = str(num,s);
        System.out.println(map.toString());
    }
}
