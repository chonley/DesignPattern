package com.chonley.objectPattern.adapterParttern;

/**
 * 适配器模式--现实生活的转接板
 * a 与 b 不兼容，那么需要进行一个类进行转接功能
 */

public class Adapter {

}

//分三种，接口适配器
interface S{
     void a();
    public void b();
    public void c();
    public void d();


}

abstract class B implements S{

    public void a(){}
}
