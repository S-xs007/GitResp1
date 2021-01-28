package com.dragon.多线程与高并发.多线程问题.并发设计模式;

import java.util.stream.IntStream;

/**
 * @author coder01
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<Object> cache = new ThreadLocal<Object>(){
            @Override
            protected Object initialValue() {
                return new Object();
            }
        };
        //等同于
        //ThreadLocal<Object> cache1 = ThreadLocal.withInitial(Object::new);
        IntStream.range(0,10).forEach(i->new Thread(()->{
            cache.set(i);
            System.out.println(Thread.currentThread().getName() + cache.get());
        }).start());
    }

}
