package com.sp.pojo.invocationHandler;

import java.lang.reflect.Method;

/**
 * 具体日志类
 */
public class MyLoggerImpl implements MyLogger {
    @Override
    public void saveIntoMethodTime(Method method) {
        System.out.println("进入" + method.getName() + "方法的时间为:" + System.currentTimeMillis());
    }

    @Override
    public void saveOutMethodTime(Method method) {
        System.out.println("退出" + method.getName() + "方法的时间为:" + System.currentTimeMillis());
    }
}
