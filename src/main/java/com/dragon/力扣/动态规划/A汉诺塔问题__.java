package com.dragon.力扣.动态规划;

/**
 * 三种圆盘，三个柱子
 * 不能大压小
 */
public class A汉诺塔问题__ {

    public static void hanoi2(int n){
        if(n>0){
            func(n,"left","right","other");
        }
    }
    public static void func(int n,String from,String to,String other){
        if(n==1) {
            System.out.println(" MOVE "+n+" from "+from+" to "+other);
        }else{
            func(n-1,from,other,to);
            System.out.println("MOVE "+n+" from "+from+" to "+to);
            func(n-1,other,to,from);
        }


    }

    public static void main(String[] args) {
        A汉诺塔问题__.hanoi2(3);
    }
}
