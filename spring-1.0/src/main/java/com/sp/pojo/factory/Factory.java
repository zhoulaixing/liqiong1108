package com.sp.pojo.factory;

/**
 * 抽象工厂类，所有工厂类的父类，只提供工厂，具体类的提供由子类实现
 */
public interface Factory {
    Vehicle produce();
}
