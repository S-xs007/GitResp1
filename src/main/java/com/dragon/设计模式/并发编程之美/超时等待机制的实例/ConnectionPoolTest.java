package com.dragon.设计模式.并发编程之美.超时等待机制的实例;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zxS
 * @Date: 19:26 2020/11/19
 * @Description：测试线程池的并发能力
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);

    static CountDownLatch start = new CountDownLatch(1);    //办证所有的ConnectionRunner同时开始

    static CountDownLatch end;  //main线程将会等待所有ConnectionRunner结束后才能继续执行

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 10;//10个线程
        end = new CountDownLatch(threadCount);

        int count = 20; //每个线程请求20次
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for(int i = 0;i<threadCount;i++){   //开启10个线程
            Thread thread = new Thread(new ConnectionRunner(count,got,notGot),
                    "ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();  //10个线程创建完成之后才开始让他们同时启动
        end.await();
        System.out.println("total invoke: "+ (threadCount*count));
        System.out.println("got connection: " + got);
        System.out.println("notGot connection: " + notGot);
    }


    /**
     * 静态内部类
     *
     */
    static class ConnectionRunner implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;
        public ConnectionRunner(int count,AtomicInteger got,AtomicInteger notGot){
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() { //
            try{
                start.await();  //利用门栓阻塞
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (count>0){
                try{
                    //从线程池获取连接，如果1000ms内无法获取到，就返回null
                    //分别统计连接获取的数量got和为获取到的数量neoGot
                    Connection connection = pool.fetchConnection(1000);
                    if(connection != null){
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }

                    }else {
                        notGot.incrementAndGet();
                    }
                } catch (Exception e){

                }finally {
                    count--;
                }
            }
            end.countDown();//执行完一个线程，门栓--，10个线程全部执行完成，main线程才会继续执行
        }
    }
}
