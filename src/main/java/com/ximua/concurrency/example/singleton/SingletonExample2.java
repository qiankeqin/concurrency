package com.ximua.concurrency.example.singleton;

import com.ximua.concurrency.annotations.NotThreadSafe;
import com.ximua.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 */
@ThreadSafe
public class SingletonExample2 {
    //私有构造函数
    private SingletonExample2(){

    }

    //单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }
}
