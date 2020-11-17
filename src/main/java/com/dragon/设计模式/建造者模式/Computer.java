package com.dragon.设计模式.建造者模式;

import java.security.MessageDigest;

/**
 * 建造者模式和工厂模式对比
 * 工厂模式就是简单的new出来
 * 建造者模式关注点是如何使用简单的对象构造出复杂的对象
 */
public class Computer {
    private Cpu cpu;
    private Gpu gpu;
    private Memory memory;
    private Monitor monitor;

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public void setGpu(Gpu gpu) {
        this.gpu = gpu;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu.getName() +
                ", gpu=" + gpu.getName() +
                ", memory=" + memory.getName() +
                ", monitor=" + monitor.getName() +
                '}';
    }
}

class Commander{
    public static Computer  buildMidComputer(ComputerBuilder builder){
        builder.setCpu();
        builder.setGpu();
        builder.setMemory();
        builder.setMonitor();
        return builder.getComputer();
    }
}

class MiddleComputerBuilder implements ComputerBuilder{
    Computer midComputer = null;
    public MiddleComputerBuilder(){
        midComputer = new Computer();
    }


    @Override
    public void setCpu() {
        Cpu cpu = new Cpu();
        cpu.setName("i7-8700k");
        midComputer.setCpu(cpu);
    }

    @Override
    public void setGpu() {
        Gpu gpu = new Gpu();
        gpu.setName("gtx-1660s");
        midComputer.setGpu(gpu);
    }

    @Override
    public void setMemory() {
        Memory memory = new Memory();
        memory.setName("1T");
        midComputer.setMemory(memory);
    }

    @Override
    public void setMonitor() {
        Monitor monitor = new Monitor();
        monitor.setName("明基");
        midComputer.setMonitor(monitor);
    }

    @Override
    public Computer getComputer() {
        return midComputer;
    }



}

/**
 * 电脑组装的规范
 */
interface ComputerBuilder{
    void setCpu();
    void setGpu();
    void setMemory();
    void setMonitor();
    Computer getComputer();
}


class Cpu{
    private String name;

    public String getName() {
        return name;
    }
    public Cpu setName(String name) {
        this.name = name;
        return this;
    }
}
class Gpu{
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Memory{
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Monitor{
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Test1{
    public static void main(String[] args) {
        Computer computer = Commander.buildMidComputer(new MiddleComputerBuilder());
        System.out.println(computer.toString());
    }
}