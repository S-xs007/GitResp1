package com.dragon.多线程与高并发.线程交替打印.并发包juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;
/**
 * @Author: zxS
 * @Date: 19:19 2020/11/24
 * @Description：使用Fork/Join框架
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2; //阈值
    private int start;
    private  int end;

    public CountTask(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end-start) <= THRESHOLD;  //判断任务量是否足够小
        if(canCompute){
            for(int i = start;i<=end;i++){
                sum += i;
            }
        }else {
            int middle = (start+end)/2;
            CountTask leftCountTask = new CountTask(start,middle);
            CountTask rightCountTask = new CountTask(middle+1,end);
            //执行子任务
            leftCountTask.fork();
            rightCountTask.fork();
            int leftResult = leftCountTask.join();
            int rightResult = rightCountTask.join();
            sum = leftResult+rightResult;
        }
        return sum;
    }


    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        //生成一个计算任务 ，计算1+2+3+4
        CountTask task = new CountTask(1,4);
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
