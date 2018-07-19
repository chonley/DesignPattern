package com.chonley.objectPattern.decoraterPattern;

/**
 * 装饰者模式：动态的将属性附加到对象上，核心是完成各个类与类的解耦，
 * 下面采用武器的例子来说明
 * 定义：装饰模式是在不必改变原类文件和使用继承的情况下，动态地扩展一个对象的功能。它是通过创建一个包装对象，也就是装饰来包裹真实的对象。
 */

public class Decorater {
}


//超类，武器

interface Weapon{
    public int calculateNum();

    public String describe();
}

//具体的武器
class Shoe implements Weapon{

    @Override
    public int calculateNum() {
        return 5;
    }

    @Override
    public String describe() {

        return "超能跑鞋。。";
    }
}


//装饰品，所有的装饰品作为一个宏观上的类，做一个总的接口
interface WeaponDecorater extends Weapon{

}


//真正的装饰品

class BlueGemDecorater implements WeaponDecorater{
    //由于比装备低一级，那么每一个装饰类需要维护一个具体的装备
    private Weapon weapon;

    public BlueGemDecorater(Weapon weapon){
        this.weapon = weapon;
    }


    @Override
    public int calculateNum() {
        return weapon.calculateNum()+10;
    }

    @Override
    public String describe() {
        return weapon.describe()+ "装配蓝宝石";
    }
}


class RedGemDecorater implements WeaponDecorater{
    private Weapon weapon;

    public RedGemDecorater(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public int calculateNum() {
        return weapon.calculateNum()+40;
    }

    @Override
    public String describe() {
        return weapon.describe()+"装配了红宝石";
    }
}


class Text{
    public static void main(String[] args){
        Weapon shoe = new RedGemDecorater(new BlueGemDecorater(new Shoe()));
        System.out.println("描述："+shoe.describe());
        System.out.println("攻击力："+shoe.calculateNum());



    }
}

