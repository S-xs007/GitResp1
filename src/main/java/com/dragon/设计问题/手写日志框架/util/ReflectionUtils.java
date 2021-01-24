package com.dragon.设计问题.手写日志框架.util;

import com.dragon.设计问题.手写日志框架.ConfigException;

import java.lang.reflect.Field;

/**
 * 简易反射工具类，演示代码，不做缓存
 */
public class ReflectionUtils {
    //为给定对象的字段赋值
    public static void setFiled(Object instance,String fieldName,String fieldValue){
        Class<?> clazz = instance.getClass();
        try{
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance,fieldValue);
        }catch (ReflectiveOperationException e){
            throw new ConfigException(e);
        }
    }
    //创建对象
    public static Object newInstance(Class<?> clazz){
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            throw new ConfigException(e);
        } catch (IllegalAccessException e) {
            throw new ConfigException(e);
        }
    }

}
