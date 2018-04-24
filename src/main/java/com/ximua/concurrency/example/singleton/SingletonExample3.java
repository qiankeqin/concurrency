package com.ximua.concurrency.example.singleton;

import com.ximua.concurrency.annotations.NotThreadSafe;
import com.ximua.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 */
@ThreadSafe
public class SingletonExample3 {
    //私有构造函数
    private SingletonExample3(){

    }

    //单例对象
    private static SingletonExample3 instance = null;

    //静态工厂方法
    //但是带来了性能上的开销
    public synchronized static SingletonExample3 getInstance(){
        if(instance ==null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
