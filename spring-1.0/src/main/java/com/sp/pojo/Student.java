package com.sp.pojo;

/**
 * 实现类的单例模式
 */
/*************** 饿汉模式 ***************/
public class Student {

    // 自动对外提供实例
    private static final Student student = new Student();
    // 私有化构造方法
    private Student(){}
    // 提供外部可以获取该实例的方法
    public static Student getStudent(){
        return student;
    }
}
/*************** 带同步锁的懒汉模式 ***************/
class _Student{

    // volatile关键字能让jvm不重拍指令，可以防止单例类被多个线程创建的时候出错
    private static volatile _Student student = null;
    // 私有化构造方法
    private _Student(){}
    // 当单例类比较大的时候建议创建时延迟且要保证线程安全，锁不加在方法上是为了缩小锁的范围，避免造成系统的瓶颈
    // 双重校验
    public static _Student getStudent(){
        if(student == null){
            synchronized (_Student.class){
                if (student == null){
                    student = new _Student();
                }
            }
        }
        return student;
    }
}
/*************** 静态内部类单例模式 ***************/
class __Student{
    // 私有静态内部类，这样类加载器会负责加锁，从而解决线程安全问题
    private static class StudentHolder{
        private static __Student student = new __Student();
    }
    // 私有化构造方法
    private __Student(){}
    // 提供外部能获取实例的方法
    public static __Student getStudent(){
        return StudentHolder.student;
    }



}