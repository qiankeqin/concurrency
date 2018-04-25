package com.ximua.concurrency.example.singleton;

import com.ximua.concurrency.annotations.Recommand;
import com.ximua.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

@ThreadSafe
@Recommand
public class SingletonExample7 {
    private SingletonExample7(){

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;
        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton() {
            return singleton;
        }
    }
}
