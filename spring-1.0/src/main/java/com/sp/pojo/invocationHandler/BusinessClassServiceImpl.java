package com.sp.pojo.invocationHandler;

/**
 * 具体业务类
 */
public class BusinessClassServiceImpl implements BusinessClassService {
    @Override
    public void doSomeThing() {
        System.out.println("do something......");
    }
}
