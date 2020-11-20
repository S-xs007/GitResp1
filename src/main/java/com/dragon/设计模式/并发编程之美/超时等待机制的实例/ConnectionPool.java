package com.dragon.设计模式.并发编程之美.超时等待机制的实例;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<Connection>();

    /**
     * 初始化方法，向线程池加入线程
     * @param size
     */
    public ConnectionPool(int size){
       if(size>0){
           for(int i = 0;i<size;i++){
               pool.addLast(ConnectionDriver.createConnection());
           }
       }
    }

    /**
     * 释放数据库连接之后需要通知其他线程
     * @param connection 需要释放的连接
     */
    public void releaseConnection(Connection connection){
        if(connection != null){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();
            }
        }
    }

    public Connection fetchConnection(long mills) throws InterruptedException {
        synchronized (pool){
            //完全超时
            if(mills<0){
                while(pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else{
                long future = System.currentTimeMillis()+mills;
                long remaining = mills;
                while(pool.isEmpty()&&remaining>0){
                    pool.wait(mills);
                    remaining = System.currentTimeMillis()-future;
                }
                Connection result = null;
                if (!pool.isEmpty()) {
                    return result = pool.removeFirst();
                }
                return result;
            }
        }
    }


}
