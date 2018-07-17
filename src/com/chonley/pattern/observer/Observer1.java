package com.chonley.pattern.observer;

/**
 * @Author: chonley
 * @Description 具体的观察者
 * @Date 2018-07-14
 */
public class Observer1 implements Observer {

    /**
     *观察者一个要实现观察者接口，还要进行注册
     */
    private Subject subject;

    public Observer1(Subject subject){
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("更新消息了："+msg);
    }
}
