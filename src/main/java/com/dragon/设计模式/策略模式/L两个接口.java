package com.dragon.设计模式.策略模式;

/**
 * Comparator就是标准的策略模式
 * 对象的某个行为在不同的环境下算法不同
 * 策略模式就是封装这个算法，然后在不同情况下用不同的算法
 */
public class L两个接口 {
    public static void main(String[] args) {
        Role role = new Role();
        role.setWeapon(new axe());  //初始武器是斧子
        role.attach();
        role.attach();
        role.attach();
        role.setWeapon(new Gun());  //捡到了一把枪
        role.attach();
        role.attach();
        role.attach();
    }
}
//武器类
interface Weapon{
    void attach();
}

class axe implements Weapon{

    @Override
    public void attach() {
        System.out.println("用斧子砍");
    }
}

class Gun implements Weapon{

    @Override
    public void attach() {
        System.out.println("用枪shoot");
    }
}

class Role {
    private Weapon weapon;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attach(){
        weapon.attach();
    }
}