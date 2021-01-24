package com.dragon.多线程与高并发.线程交替打印.复杂的线程池;



import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class UnsafeExample   {
    private static final int CLIENT_TOTAL = 30000;
    private static final int THREAD_TOTAL = 300;
    private static volatile int count = 0;
    public static void main(String[] args) throws InterruptedException {
        //模拟并发
        ExecutorService executorService = Executors.newCachedThreadPool();  //线程池
        CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);   //3万个门栓
        Semaphore semaphore = new Semaphore(THREAD_TOTAL);      //300个并发
        for(int i = 0;i<CLIENT_TOTAL;i++){
            executorService.execute(()->{
                try{
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                    log.error(e.getMessage(),e);
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println("统计次数："+count);
    }

    private static void add(){
        count++;
    }
}