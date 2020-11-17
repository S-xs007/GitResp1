package com.dragon.设计模式.抽象工厂模式重构数据库连接池;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class Pool {
    private String propertiesName = "A.properties";
    private static final Object lock = new Object();
    private static Pool instance = null;

    protected int maxConnect = 100; //最大连接数
    protected int normalConnect = 10; //保持连接数
    protected String driverName = null;
    protected Driver driver = null; //驱动变量
    protected Pool(){
        init();
        loadDrivers(driverName);
    }



    private   void init(){
        try {
            InputStream in = Pool.class.getResourceAsStream(propertiesName);    //流---配置文件
            Properties properties = new Properties();
            properties.load(in);    //加载到配置类中
            this.driverName = properties.getProperty("driverName");
            this.maxConnect = Integer.parseInt(properties.getProperty("maxConnect"));
            this.normalConnect = Integer.parseInt(properties.getProperty("normalConnect"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected  void loadDrivers(String driverName){
        String driverClassName = null;
        try {
            driver = (Driver)Class.forName(driverClassName).newInstance();  //反射获取驱动类
            DriverManager.registerDriver(driver);  //注册驱动
            System.out.println("成功注册驱动程序"+driverClassName);

        } catch (Exception e) {
            System.out.println("无法注册驱动程序"+driverClassName+"错误"+e);
        }
    }

    /**
     * 创建连接池
     */
    public abstract void createPool();

    /**
     * DCL单例模式
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Pool getInstance() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if(instance==null){
            synchronized (lock){
                if(instance==null){
                    instance = (Pool) Class.forName("Pool").newInstance();
                }
            }
        }
        return instance;
    }
    //获取连接
    public abstract Connection getConnection();
    public abstract Connection getConnectionTime(long time);
    public abstract void freeConnection(Connection connection);
    public abstract int getNum();       //获取当前空闲连接数
    public abstract int getNumActive();
    public synchronized void release(){
        try {
            DriverManager.deregisterDriver(driver); //撤销驱动
            System.out.println("撤销驱动"+driver.getClass().getName());
        } catch (SQLException e) {
            System.out.println("无法撤销驱动"+driver.getClass().getName());
        }

    }
}
