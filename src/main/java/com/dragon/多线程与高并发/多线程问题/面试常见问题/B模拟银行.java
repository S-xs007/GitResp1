package com.dragon.多线程与高并发.多线程问题.面试常见问题;

import java.util.concurrent.TimeUnit;

public class B模拟银行 {
}

/**
 * 模拟银行
 * 写方法同步
 * 读方法不同步可以吗
 * 容易产生脏读
 */
class Bank{
    private String name;
    private int balance;

    public  void getBalance(){

        System.out.println(this.balance);
    }
    //存钱方法同步
    public synchronized void setBalance(int balance){
        //模拟存钱等待时间2s
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank();
        //存款之前先查询余额
        System.out.println("存款之前先查询余额");
        bank.getBalance();
        //存款
        new Thread(()->bank.setBalance(100),"t1").start();
        //存款之后在查询
        System.out.println("存款之后在查询");
        //读到了脏数据
        bank.getBalance();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("再次查询");
        bank.getBalance();
    }


}