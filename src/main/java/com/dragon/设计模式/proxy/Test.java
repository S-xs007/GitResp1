package com.dragon.设计模式.proxy;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IOException, ClassNotFoundException {
        CPMeiPo cpMeiPo = new CPMeiPo();
        IPerson zhangsan = cpMeiPo.getInstance(new Zhangsan()); //这里的zhansan就是代理类对象
        zhangsan.findLove();
    }
}
