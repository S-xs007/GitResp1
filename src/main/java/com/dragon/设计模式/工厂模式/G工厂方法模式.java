package com.dragon.设计模式.工厂模式;
/**
 * @Author: zxS
 * @Date: 21:30 2020/11/20
 * @Description：工厂方法模式就是有一个工厂父接口
 * 简单工厂就是万能工厂，扩展不容易，工厂方法就是单一职责，不同的工厂创建不同的对象
 */
public class G工厂方法模式 {
    public static void main(String[] args) {
        IFactory factory = new FactoryA();
        factory.createProduct().doSomething();
    }
}
interface IFactory{
    IProduct createProduct();
}
class FactoryA implements IFactory{

    @Override
    public IProduct createProduct() {
        return new ProductA();
    }
}
class FactoryB implements IFactory{

    @Override
    public IProduct createProduct() {
        return new ProductB();
    }
}