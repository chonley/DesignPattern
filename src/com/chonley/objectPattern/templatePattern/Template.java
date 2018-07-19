package com.chonley.objectPattern.templatePattern;

/**
 * 模板设计模式
 * 定义：定义一个操作中算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变算法的结构即可重定义该算法的某些特定步骤。
 * 理解：做一件事有固定的步骤，但是每个人虽然是固定的步骤，但是有不同的方法
 */


public class Template {
}

abstract class Work{
    protected String name ;
    public  Work(String name ){
        this.name = name;
    }


    public void demo1(){
        a();
        b();
        c();
        d();

    }

    protected abstract void d();

     void c(){
         System.out.println("c");
     };

    void b(){
        System.out.println("b");
    };

    protected abstract void a();


}

class ITwork extends Work{

    public ITwork(String a){
        super(a);
    }

    @Override
    protected void d() {
        System.out.println(name+"ddd");
    }

    @Override
    protected void a() {
        System.out.println(name+"jutie ");
    }
}

class Test{
    public static void main(String[] args){
        Work work  = new ITwork("张三");
        work.demo1();
    }
}