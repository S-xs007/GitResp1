package com.dragon.设计模式.并发编程之美.数据库连接池实现web服务器;

public interface ThreadPool<Job extends Runnable> {
    void execute (Job job); //执行任务
    void shutDown();        //关闭连接池
    void addWorks(int num); //添加工作线程
    int getJobSize();      //得到正在等待执行的任务数量
    void removeWorker(int num); //减少工作线程
}
