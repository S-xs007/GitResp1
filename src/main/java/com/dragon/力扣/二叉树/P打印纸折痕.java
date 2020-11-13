package com.dragon.力扣.二叉树;

/**
 * 打印纸折痕(就是中序)
 */
public class P打印纸折痕 {

    public static void printPaper(int x){
        print(1,x,true);
    }

    //true表示左子树  fasle表示右子树
    public static void print(int x,int n,boolean flag){
        if(x>n)return;
        print(x+1,n,true);
        System.out.println(flag?"凹":"凸");
        print(x+1,n,false);
    }

    public static void main(String[] args) {
        P打印纸折痕.printPaper(3);
    }
}
