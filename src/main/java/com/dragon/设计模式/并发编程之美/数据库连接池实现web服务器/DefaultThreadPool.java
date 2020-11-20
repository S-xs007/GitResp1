package com.dragon.设计模式.并发编程之美.数据库连接池实现web服务器;

import javafx.concurrent.Worker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * @Author: zxS
 * @Date: 19:59 2020/11/19
 * @Description：线程池的实现类
 */
public class DefaultThreadPool <Job extends Runnable> implements ThreadPool<Job>{
    private static final int MAX_WORKER_NUMBERS = 10;       //最大work线程数
    private static final int DEFAULT_WORKER_NUMBERS = 5;    //默认
    private static final int MIN_WORKER_NUMBERS = 1;        //最小
    //线程安全的工作线程集合
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());
    //任务队列
    private final LinkedList<Job> jobs = new LinkedList<>();
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    private AtomicInteger threadNum = new AtomicInteger();

    public DefaultThreadPool(){
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }
    public DefaultThreadPool(int num){
        workerNum = num > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : num<MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS:num;
        initializeWorkers(DEFAULT_WORKER_NUMBERS);
    }

    //添加工作线程到线程集合中
    private void initializeWorkers(int num) {
        for(int i = 0;i<num;i++){
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker,"ThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null){
            synchronized (jobs){
                jobs.addLast(job);  //把任务放到任务队列中，然后随机通知一个工作线程来执行
                jobs.notify();
            }
        }
    }

    @Override
    public void shutDown() {
        for(Worker worker:workers){
            worker.shutdown();
        }
    }

    //添加工作线程
    @Override
    public void addWorks(int num) {
        synchronized (jobs){
            if(num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS;
            }
            initializeWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    //移除工作线程
    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if(num >= this.threadNum.get()){
                throw new IllegalArgumentException("beyond workNum");
            }
            //按照给定的数量停止Worker
            int count = 0;
            while (count<num){
                Worker worker = workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    class Worker implements Runnable{
        private volatile boolean running = true;
        @Override
        public void run() {
            while(running){
                Job job = null;
                synchronized (jobs){
                    //如果工作列表为空，，就wait
                    while (jobs.isEmpty()){
                        try{
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    //取出一个job
                    job = jobs.removeFirst();
                }
                if(job!=null){
                    try{
                        job.run();
                    }catch (Exception ex){
                        //忽略
                    }
                }
            }
        }
        public void shutdown(){
            running = false;
        }

    }
}
