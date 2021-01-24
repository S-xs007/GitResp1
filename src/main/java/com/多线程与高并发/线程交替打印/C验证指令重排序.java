package com.多线程与高并发.线程交替打印;

public class C验证指令重排序 {
    static int a = 0;
    static int b = 0;
    static int x =0;
    static int y = 0;
    public static void main(String[] args) throws InterruptedException {

        for(;;) {
            a=0;b=0;x=0;y=0;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    y = b;
                }
            });
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 2;
                    x = a;
                }
            });
            thread.start();
            thread1.start();
            thread.join();
            thread1.join();
            System.out.println(y + "    " + x);
        }


    }
}
