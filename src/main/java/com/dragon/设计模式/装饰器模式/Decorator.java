package com.dragon.设计模式.装饰器模式;

/**
 * 装饰器设计模式
 * 星巴克卖coffee           Decaf Espresso DrakRoast HouseBlend
 */
public class Decorator {


}


/**
 * 抽取coffee共性
 */
abstract class Beverage{
    private String description;
    public Beverage(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double cost();  //花费
}

/**
 * 无咖啡因咖啡
 */
class Decaf extends Beverage{

    public Decaf() {
        super("无咖啡因咖啡");
    }

    @Override
    public double cost() {
        return 1;
    }
}

/**
 * 浓缩咖啡
 */
class Espresso extends Beverage{
    public Espresso() {
        super("浓缩咖啡");
    }
    @Override
    public double cost() {
        return 5;
    }
}



class AppTest{
    public static void main(String[] args) {
        Beverage beverage = new Decaf();
        System.out.println(beverage.getDescription()+beverage.cost());
    }
}

