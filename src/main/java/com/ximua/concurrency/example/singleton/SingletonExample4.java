package com.ximua.concurrency.example.singleton;

import com.ximua.concurrency.annotations.NotThreadSafe;
import com.ximua.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 由于指令重排，仍然是不安全的
 */
@NotThreadSafe
public class SingletonExample4 {
    //私有构造函数
    private SingletonExample4(){

    }

    //单例对象
    private static SingletonExample4 instance = null;

    //静态工厂方法
    //但是带来了性能上的开销
    public static SingletonExample4 getInstance(){
        if(instance ==null){ //double check双重检测机制
            synchronized (SingletonExample4.class){ //同步锁
                if(instance == null){
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
