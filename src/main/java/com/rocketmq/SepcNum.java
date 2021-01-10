package com.rocketmq;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SepcNum {
    public static int Num(int n){
        if(n == 0)return -1;    //这行代码可以不写，不影响结果
        int a = 1;
        int b = 1;
        int c = 1;
        int[] db = new int[n+1];
        db[1] = 1;
        db[0] = 0;
        for(int i = 2;i<=n;i++){
            int temA = db[a]*2;
            int temB = db[b]*3;
            int temC = db[c]*7;
            int min = Math.min(temA,Math.min(temB,temC));
            db[i] = min;
            if(min == temA)a++;
            if(min == temB)b++;
            if(min == temC)c++;
        }
        return db[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> res = new LinkedList<>();
        String tem;
        while( !(tem = scanner.nextLine()).equals("0")){
            res.add(Num(Integer.parseInt(tem)));
        }
        Iterator<Integer> iterator = res.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
