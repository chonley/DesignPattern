package com.chonley.objectPattern.factoryPattern;

/**
 * 工厂方法模式
 */
public class FactoryMethodPattern {
}

//抽象汽车类，后面的车都要进行继承这个抽象类。为什么不用接口，如果在抽象的模型需要进行定义属性时，接口中的都是静态常量，
 abstract class Car{
    private String name;

    public abstract void drive();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


//具体的汽车类
class Benz extends Car{

    @Override
    public void drive() {
        System.out.println("开benz了。。。。");
    }
}

//抽象的汽车工厂，不具体生产车
interface CarFactory{
    public Car createCar();
}


//具体的benz汽车工厂
class BenzFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new Benz();
    }
}

//消费者来了
class Boss{
    public static void main(String[] args){
        Car car = new BenzFactory().createCar();
        car.drive();

    }
}
