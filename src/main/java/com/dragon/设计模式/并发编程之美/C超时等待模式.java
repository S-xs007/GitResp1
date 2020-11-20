package com.dragon.设计模式.并发编程之美;
/**
 * @Author: zxS
 * @Date: 18:58 2020/11/19
 * @Description：如果超时还是没有得到对象，就返回默认值
 */
public class C超时等待模式 {
    private Object result;
    public synchronized Object get(long mills) throws InterruptedException {
        long future = System.currentTimeMillis()+mills;
        long remaining = mills;
        while(result==null&&remaining>0){
            Thread.sleep(mills);
            remaining = System.currentTimeMillis()-future;
        }
        return result;
    }
}
