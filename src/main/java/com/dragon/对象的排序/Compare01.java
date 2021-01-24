package com.dragon.对象的排序;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 外部比较器
 */
public class Compare01 {
    public static void main(String[] args) {
        //实例化外部比较器
        NumComparator comparator = new NumComparator();
        //TreeSet
        TreeSet<User> set = new TreeSet<User>(comparator);
        set.add(new User(2));
        set.add(new User(3));
        set.add(new User(5));
        set.add(new User(1));
        set.add(new User(2));
        //遍历TreeSet查看是否排序
        for(User user : set)
           System.out.println(user.age);
    }
}

//定义外部比较器，并且实现比较规则
class NumComparator implements Comparator<User> {
    @Override
    public int compare(User user1, User user2) {
        //通过年纪比较
        return user1.age-user2.age;
    }
}

//实体类
class User{
    public int age;

    public User(int age) {
        this.age = age;
    }
}