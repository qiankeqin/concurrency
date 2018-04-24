package com.ximua.concurrency.example.singleton;

import com.ximua.concurrency.annotations.NotThreadSafe;
import com.ximua.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonExample5 {
    //私有构造函数
    private SingletonExample5(){

    }

    //单例对象 volatile + double check -》 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    //静态工厂方法
    //但是带来了性能上的开销
    public static SingletonExample5 getInstance(){
        if(instance ==null){ //double check双重检测机制
            synchronized (SingletonExample5.class){ //同步锁
                if(instance == null){
                    instance = new SingletonExample5();
                }
            }
        }
        return instance;
    }
}
