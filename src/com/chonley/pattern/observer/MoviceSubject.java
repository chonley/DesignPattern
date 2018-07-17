package com.chonley.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chonley
 * @Description 电影推送，内部要维护两个变量，所有的用户以及需要更新信息
 * @Date 2018-07-14
 */
public class MoviceSubject implements Subject {

    /**
     *维护所有的观察者
     */
    List<Observer> lists = new ArrayList<>();

    /**
     *
     */
    String msg;


    @Override
    public void register(Observer observer) {
            lists.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = lists.indexOf(observer);
        if (index>=0){
            lists.remove(observer);
        }

    }

    @Override
    public void notifyObserver() {
        /**
         *更新所有的观察者
         */
        for(Observer o : lists){
            o.update(msg);
        }
    }

    //提供更新信息的方法,并且更新所有用户
    public void setMsg(String msg) {
        this.msg = msg;
        notifyObserver();
    }
}
