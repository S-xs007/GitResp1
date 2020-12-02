package com.dragon.多线程问题.面试常见问题;

public class S生产者消费者 {
    final static Object o = new Object();
    static int i = 0;
    static class Product implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                //满了就通知消费者
                if(i==10){
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(i<10){
                    i++;
                    System.out.println("生产者正在生成"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }
    static class Consumer implements Runnable{

        @Override
        public void run() {
            synchronized (o){
                if(i==0){
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while(i>0){
                    System.out.println("消费者消费了"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i--;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
    }

    public static void main(String[] args) {
        S生产者消费者.Consumer consumer = new Consumer();
        S生产者消费者.Product product = new Product();
        new Thread(product).start();
        new Thread(product).start();
        new Thread(product).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
        new Thread(consumer).start();
    }

}



