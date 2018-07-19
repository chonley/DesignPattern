package com.chonley.objectPattern.strategyPattern;

/**
 * 策略设计模式--行为型模式
 * 定义：定义了算法族，分别封装起来，运行时让它们之间可相互替换，此模式让算法的变化独立于使用算法的客户。
 *
 */

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 需求：每个角色对应一个名字，每类角色对应一种样子，每个角色拥有一个逃跑、攻击、防御的技能。
 * 1、普通的想法,没加一个，就要去继承或者实现一个Role，代码重复多，换用策略模式
 * 2、策略模式，将变得东西做成接口，用户这边这道自己的技能，会在创建的时候建立告诉实例化的，这样变得东西在创建的时候就确定了，
 */
public class Strategy {

    abstract class Role{
        private String name;

        public abstract void display();
        public abstract void attack();
        public abstract void defend();

    }


    class Role1 extends Role{

        @Override
        public void display() {
            System.out.println("样式1");
        }

        @Override
        public void attack() {
            System.out.println("攻击1");
        }

        @Override
        public void defend() {
            System.out.println("防御1");
        }
    }

    class Role2 extends Role{

        @Override
        public void display() {
            System.out.println("样子2");
        }

        @Override
        public void attack() {
            System.out.println("攻击2");
        }

        @Override
        public void defend() {
            System.out.println("防御2");
        }
    }

/***********************************华丽的分割线*************************************************************************/


    interface IAttackBehavior{
        void attack();
    }

    interface IDefendBehavior{
        void defend();
    }

    interface IDisplayBehavior{
        void display();
    }

    class Attack1 implements IAttackBehavior{
        @Override
        public void attack() {
            System.out.println("攻击一");
        }
    }

    class Defend1 implements IDefendBehavior{
        @Override
        public void defend() {
            System.out.println("防守一");
        }
    }


    class Display1 implements IDisplayBehavior{
        @Override
        public void display() {
            System.out.println("样式一");
        }
    }

    abstract class Role0{

        public String name;

        private IDisplayBehavior iDisplayBehavior;
        private IDefendBehavior iDefendBehavior;
        private IAttackBehavior IAttackBehavior;

        public Role0 setIDisplayBehavior(IDisplayBehavior iDisplayBehavior){    //这里返回的this，我现在的理解是用于链式编程，返回这个对象后面就可以一直点下去设置了
            this.iDisplayBehavior = iDisplayBehavior;
            return this;
        }

        public Role0 setIDefendBehavior(IDefendBehavior iDefendBehavior){
            this.iDefendBehavior = iDefendBehavior;
            return this;
        }

        public Role0 setIAttackBehavior(IAttackBehavior iAttackBehavior){
            this.IAttackBehavior = iAttackBehavior;
            return this;
        }

        public void display(){
            iDisplayBehavior.display();
        }

        public void attack(){
            IAttackBehavior.attack();
        }

        public void defend(){
            iDefendBehavior.defend();
        }

    }


    class RoleA extends Role0{
        public RoleA(String name){
                this.name = name;
        }
    }



}


//closing class  不能再类的外部实例化类的内部类，先把外部类实例化出来，再来用实例化的类来实例化内部类
class Test{
    public static void main(String[] args){

        Strategy a = new Strategy();
        /*
        Strategy.Role role1 = a.new Role1();
        role1.attack();
        */

        Strategy.Role0 A = a.new RoleA("A");
        A.setIAttackBehavior(a.new Attack1()).setIDefendBehavior(a.new Defend1()).setIDisplayBehavior(a.new Display1());
        A.attack();
        A.display();


    }
}


















