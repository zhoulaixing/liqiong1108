package com.sp.pojo.invocationHandler;

import java.lang.reflect.Method;

/**
 * 日志接口
 */
public interface MyLogger {
    // 方法执行之前的时间
    void saveIntoMethodTime(Method method);

    // 方法执行之后的时间
    void saveOutMethodTime(Method method);
}
