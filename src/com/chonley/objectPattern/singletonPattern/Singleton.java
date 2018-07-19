package com.chonley.objectPattern.singletonPattern;

/**
 * 单例设计模式
 */

//饿汉式 .1-利用static进行实例化
public class Singleton {

    public static Singleton instance = new Singleton();

    private  Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}


//饿汉式 .2-利用static代码块
class Singleton1{
    private static Singleton1 instance1 = null;

    static {
        instance1 = new Singleton1();
    }

    private Singleton1(){}

    public static Singleton1 getInstance1(){
        return instance1;
    }

}


//懒汉式 getInstance才创建对象，那么会导致线程安全的问题,当两个线程同时判断进入if后，会创建两个对象
class Singleton2{

    private static Singleton2 instance2 = null;

    private Singleton2(){}

    public static Singleton2 getInstance2(){

        if (instance2 == null){
            return new Singleton2();
        }
        return instance2;
    }
}



//懒汉式 改进后，双重锁,第一次判断一下，后面拿到锁后再来判断一下有没有对象  DCL double checked locking
class Singleton3{
    private static Singleton3 singleton3 = null;

    private Singleton3(){}

    public static Singleton3 getSingleton3(){
        if (singleton3 == null){
            synchronized (Singleton3.class){
                if (singleton3 == null){
                    return new Singleton3();
                }
            }
        }
        return singleton3;
    }
}


//静态内部类，有点没看懂(静态类直接用，再程序装载的时候就已经实例化了)  与饿汉式相比，实现的lazy-loading
//静态内部类，当你使用它的时候才加载
//内部类使用static，可以将内部类与类的关系进行隔绝
class Singleton4{

    private static Singleton4 singleton4 = null;

    private Singleton4(){}

    private static class InnerClass{
        public static Singleton4 Singleton4 = new Singleton4();
    }

    public static Singleton4 getSingleton4(){
        return InnerClass.Singleton4;
    }

}

//枚举？   枚举实例创建是thread-safe

enum Singleton5{

    singleton5;

    private Singleton5(){}

    public void method(){}

}

class Test{
    public static void main(String[] args){
        Singleton5.singleton5.method();
    }

}























