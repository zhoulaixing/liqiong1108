package com.sp.pojo.factory;

/**
 * 具体类，汽车类
 */
public class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("我是汽车类");
    }
}
