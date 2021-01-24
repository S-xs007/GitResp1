package com.多线程与高并发.多线程问题.面试常见问题;

public class H缓存行对齐 {
    private static class p{
        //一共56字节
        private volatile long p1,p2,p3,p4,p5,p6,p7;
    }
    //继承了p就一共64字节，刚好一个缓存行，这样就会导致
    //缓存行1：t[0]的p1-p7-x
    //缓存行2：t[1]的p1-p7-x
    private static class T extends p{
        //8字节
        private volatile long x = 0L;
    }
    private static T[] t = new T[2];
    //静态初始化块（如果没有继承p就会放在同一缓存行）
    static{
        t[0] = new T();
        t[1] = new T();
    }
   public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()->{
            for(long i = 0;i<1000_0000L;i++){
                t[0].x = i;
            }
        });
        Thread thread2 = new Thread(()->{
            for(long i = 0;i<1000_0000L;i++){
                t[1].x = i;
            }
        });
        //两个线程会修改同一个缓存行中的不同数据，由于有volatile关键字，会导致没修改一次都会通知另外一个线程重新读取
       final long startTime = System.nanoTime();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println((System.nanoTime()-startTime)/100_0000);
    }
}
