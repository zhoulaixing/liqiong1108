package com.sp.pojo.factory;

/**
 * 自行车类的工厂
 */
public class BicycleFactory implements Factory{
    @Override
    public Vehicle produce() {
        return new Bicycle();
    }
}
