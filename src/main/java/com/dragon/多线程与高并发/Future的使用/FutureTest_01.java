package com.dragon.多线程与高并发.Future的使用;

import java.util.concurrent.*;
import java.util.concurrent.Future;

public class FutureTest_01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        //定义阻塞队列
        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>();
        //自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(4, 5, 1, TimeUnit.MINUTES, blockingDeque);
        Future<Boolean> future = pool.submit(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                //do someThing
                return true;
            }
        });
        //该方法会一直阻塞等待结果
        future.get();
        //该方法只等待两分钟
        future.get(2L,TimeUnit.MINUTES);

    }
}
