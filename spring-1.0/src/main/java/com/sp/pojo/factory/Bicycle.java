package com.sp.pojo.factory;

/**
 * 具体类,自行车类
 */
public class Bicycle implements Vehicle{
    @Override
    public void run() {
        System.out.println("我是自行车类");
    }
}
