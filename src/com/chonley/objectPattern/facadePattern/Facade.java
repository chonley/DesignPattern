package com.chonley.objectPattern.facadePattern;


/**
 * 外观模式：将所有的接口进行封装，直接对用户提供一个接口，进行集体操作
 */
public class Facade {
}

interface FacadeAll{

    void start();
    void close();
}

class OneKeyController implements FacadeAll{
    //各种对象全部注入进来







    @Override
    public void start() {
        //再寄来进行一起操作
    }

    @Override
    public void close() {

    }
}