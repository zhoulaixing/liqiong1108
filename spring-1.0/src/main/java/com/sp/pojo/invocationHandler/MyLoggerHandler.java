package com.sp.pojo.invocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 日志Handler
 */
public class MyLoggerHandler implements InvocationHandler {
    // 原始类，也就是被代理的类
    private Object object;
    // 日志类
    private MyLogger myLogger = new MyLoggerImpl();

    public MyLoggerHandler(Object obj){
        super();
        this.object = obj;
    }



    /**
     * @param proxy     代理类对象
     * @param method    被代理的方法
     * @param args      被代理的方法所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        this.myLogger.saveIntoMethodTime(method);
        result = method.invoke(this.object,args);
        this.myLogger.saveOutMethodTime(method);
        return result;
    }
}
