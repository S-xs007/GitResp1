package com.dragon.设计模式.proxy;

import java.io.IOException;
import java.lang.reflect.Method;

public class CPMeiPo implements CPInvocationHandler{
    private IPerson target;

    public  IPerson getInstance(IPerson target) throws NoSuchMethodException, IOException, ClassNotFoundException {
        this.target = target;
        Class<?> clazz = target.getClass();
        return (IPerson)CPProxy.newProxyInstance(new CPClassLoader(),clazz.getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
        before();
        Object result = method.invoke(this.target,args);
        after();
        return result;
    }

    private void after(){
        System.out.println("双方同意，开始交往");
    }
    private void before(){
        System.out.println("我是媒婆，开始物色");
    }

}
