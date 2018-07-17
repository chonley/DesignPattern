package com.chonley.pattern.observer;

/**
 * @Author: chonley
 * @Description 服务提供者，
 * @Date 2018-07-14
 */
public interface Subject {

    /**
     *注册观察者
     */
    public void register(Observer observer);


    /**
     *移除观察者
     */
    public void removeObserver(Observer observer);


    /**
     *通知观察者
     */
    public void notifyObserver();
}
