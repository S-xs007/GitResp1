package com.dragon.设计模式.dcl;

import java.lang.reflect.Constructor;

/**
 * 饿汉式防止反射攻击
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton()  {
        /*if(instance!=null)
            throw new RuntimeException("单例模式不允许创建多个实例");*/
    }
    private static HungrySingleton getInstance(){
        return instance;
    }

    public static void main(String[] args) throws Exception {
        Constructor<HungrySingleton> constructor = HungrySingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        HungrySingleton hungrySingleton = constructor.newInstance();
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        System.out.println(hungrySingleton==hungrySingleton1);
    }
}
