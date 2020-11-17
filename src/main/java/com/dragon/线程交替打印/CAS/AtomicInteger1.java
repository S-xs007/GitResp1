package com.dragon.线程交替打印.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInteger1 {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger();
        //拿到当前的值
        i.incrementAndGet();
        /*public final int getAndAddInt(Object var1, long var2, int var4) {
            int var5;
            do {
                var5 = this.getIntVolatile(var1, var2);
                //这里就是CAS操作
            } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

            return var5;*/
        }

    }

