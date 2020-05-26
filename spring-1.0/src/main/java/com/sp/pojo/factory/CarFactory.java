package com.sp.pojo.factory;

/**
 * 汽车类的工厂
 */
public class CarFactory implements Factory{
    @Override
    public Vehicle produce() {
        return new Car();
    }
}
