package com.dragon.设计模式.原型模式;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * java自带克隆模式 Object方法下面有一个clone方法
 */
public class P原型模式 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ConcretePrototype1 Prototype1 = new ConcretePrototype1();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        Prototype1.setId(1);
        Prototype1.setName("小明");
        Prototype1.setList(list);
        ConcretePrototype1 Prototype12 = (ConcretePrototype1) Prototype1.deepClone();
        System.out.println(Prototype1.toString());
        System.out.println(Prototype12.toString());
        System.out.println(Prototype1==Prototype12);    //fasle两个对象属性完全相同，但却不是一个对象（地址不同）
        System.out.println(Prototype1.getList()==Prototype12.getList());    //fasle
    }
}

/**
 * 浅克隆
 * 实现Cloneable接口重写clone方法调用super.clone实现浅克隆
 */
class ConcretePrototype implements Cloneable{
    @Override
    protected Object clone() throws CloneNotSupportedException {
        ConcretePrototype prototype = null;
        prototype = (ConcretePrototype) super.clone();  //该方法直接从堆内存中以二进制的形式进行对象的复制，重新分配内存区域，因此效率极高
        //因为是直接基于内存复制，所以不需要调用搞糟函数，也就是不需要进行初始化过程
        //问题：如果原型对象中有引用属性，那么克隆之后两个对象的该引用会指向同一片区域，我们希望的是而这时不同的对象，是独立的分开的
        return prototype;
    }

}

class ConcretePrototype1 implements Serializable {
    private int id;
    private String name;
    private List<Integer> list;
    /**
     * 深克隆
     * @return
     */
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return ois.readObject();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ConcretePrototype1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}