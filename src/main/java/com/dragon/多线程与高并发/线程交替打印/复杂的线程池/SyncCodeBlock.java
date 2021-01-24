package com.dragon.多线程与高并发.线程交替打印.复杂的线程池;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SyncCodeBlock {
    private static final int COUNT = 5; //静态常量

    public void syncCodeBlock(String block) {
        synchronized (this){            //同步代码块
            for(int i =0;i<COUNT;i++){
                System.out.println("同步块{"+block+"}并发-{"+i+"}");
            }
        }
        for(int i =0;i<COUNT;i++){
            System.out.println("异步块{"+block+"}并发-{"+i+"}");
        }

    }
    public void asynCodeBlock(int block) {
        for(int i =0;i<COUNT;i++){
            System.out.println("代码块{"+block+"}并发-{"+i+"}");
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();  //线程池
        SyncCodeBlock syncCodeBlock = new SyncCodeBlock();                  //模拟并发（同时运行的线程数）
        executorService.execute(()->{
            syncCodeBlock.syncCodeBlock("A");
        });
        executorService.execute(()->{
            syncCodeBlock.syncCodeBlock("B");
        });
    }
}
