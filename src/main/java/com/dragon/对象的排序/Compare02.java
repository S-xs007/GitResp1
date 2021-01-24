package com.dragon.对象的排序;

import java.util.Arrays;


public class Compare02 {
    public static void main(String[] args) {
        People[] peoples = new People[3];
        peoples[0] = new People(2);
        peoples[1] = new People(7);
        peoples[2] = new People(8);
        //sort方法可以实现对对象数组排序，但是必须实现 Comparable接口
        Arrays.sort(peoples);
        for(People people : peoples){
            System.out.println(people.getAge());
        }

    }
}

//实现内置比较器
class People implements Comparable{
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public People(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Object o) {
        People people = null;
        if(o instanceof People){
            people = (People)o;
        }
        return this.getAge()-people.getAge();
    }
}