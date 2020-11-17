package com.dragon.设计模式.适配器模式;

public class Adapter {

}

class Calc {
    //两个数相加
    public int add(int a,int b){
        return a+b;
    }
}

//适配器
class CalcAdapter{
    private Calc calc;
    
    public int add(int a, int b,int c){
        return calc.add(a,calc.add(b,c));
    }
}