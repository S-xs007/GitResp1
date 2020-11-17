package com.dragon.设计模式.proxy;

import java.lang.reflect.Method;

public interface CPInvocationHandler {
    public Object invoke(Object proxy, Method method,Object[] args)
        throws Throwable;
}
