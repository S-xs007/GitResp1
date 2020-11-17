package com.dragon.设计模式.工厂模式;

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