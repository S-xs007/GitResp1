package com.dragon.设计模式.dcl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例，适用于大量创建单例对象的场景
 */
public class ContainerSingleton {
    private ContainerSingleton(){};
    //存放单例对象的容器

    private static Map<String, Object> map = new ConcurrentHashMap<>();
    public static Object getBean(String beanName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        synchronized (map){
            //容器中没有就创建然后放进去
            if(!map.containsKey(beanName)){
                Object obj = null;
                obj = Class.forName(beanName).newInstance();
                map.put(beanName,obj);
                return obj;
            }else{
                //容器中有就直接返回
                return map.get(beanName);
            }
        }
    }
}
