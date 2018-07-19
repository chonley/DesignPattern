package com.chonley.objectPattern.factoryPattern;

/**
 * 简单工厂
 */


class SimpleFactoryPattern{

}


//抽象产品
abstract class Product{
    private String productName;

    public abstract void eat();

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}


//来一个简单的产品
class tomato extends Product {

    @Override
    public void eat() {
        System.out.println("吃马铃薯咯。。。");
    }
}


//来个简单的工厂
class FoodFactory{
    public static Product makeProduct(String msg) {
        if ("a".equals(msg)) {
            return new tomato();
        }else {
            return null;
        }
    }
}

//来个消费者
class Consumers{
    public static void main(String[] args){
        Product product = FoodFactory.makeProduct("a");
        product.eat();
    }
}