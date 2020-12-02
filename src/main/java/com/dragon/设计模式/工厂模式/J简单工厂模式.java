package com.dragon.设计模式.工厂模式;

import com.dragon.设计模式.proxy.IPerson;
/**
 * @Author: zxS
 * @Date: 21:29 2020/11/20
 * @Description：简单工厂模式就是在工厂中进行判断（if/else  switch  或者通过反射）
 */
public class J简单工厂模式 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //利用简单工厂生产产品A
        SimpleFactory.createProduct("A").doSomething();
        SimpleFactory.createProduct(ProductB.class).doSomething();
    }
}

/**
 * 抽象产品接口
 */
interface IProduct{
    void doSomething();
}

class ProductA implements IProduct{

    @Override
    public void doSomething() {
        System.out.println("A产品");
    }
}
class ProductB implements IProduct{

    @Override
    public void doSomething() {
        System.out.println("B产品");
    }
}

/**
 * 普通工厂(两个重载方法，通过不同的方式生产商品)
 */
class SimpleFactory{
    //通过商品的名字制造
    public static IProduct createProduct(String productName){
        if(productName.equals("A"))return new ProductA();
        if(productName.equals("B"))return new ProductB();
        return null;
    }
    //通过反射制造
    public static IProduct createProduct(Class<? extends IProduct> clazz) throws IllegalAccessException, InstantiationException {
        if(clazz!=null){
            return clazz.newInstance();
        }
        return null;
    }
}