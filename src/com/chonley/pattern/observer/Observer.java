package com.chonley.pattern.observer;

/**
 * @Author: chonley
 * @Description 观察者接口，每一个观察者都要实现这个接口
 * @Date 2018-07-14
 */
public interface Observer {

    public void update(String msg);

}
