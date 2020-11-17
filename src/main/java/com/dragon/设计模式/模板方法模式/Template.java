package com.dragon.设计模式.模板方法模式;

/**
 * 模板方法模式
 * 父类
 */
public abstract class Template {

    public int test(){
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();
        return (int) ((end-start)/1000);
    }
    public abstract void code();

}

class B extends Template{

    @Override
    public void code() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class A{
    public static void main(String[] args) {
        B b = new B();
        b.code();
        System.out.println(b.test());
    }
}