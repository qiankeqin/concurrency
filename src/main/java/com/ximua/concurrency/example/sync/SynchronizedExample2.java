package com.ximua.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample2 {
    //修饰一个类
    public static void test1(String j){
        synchronized(SynchronizedExample2.class){
            for(int i = 0;i<10;i++){
                System.out.println(j+" : "+i);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(String j){
        for(int i=0;i<10;i++){
            System.out.println(j+" : "+i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            SynchronizedExample2.test1("i'm example1 ");
        });
        executorService.execute(()->{
            SynchronizedExample2.test2("i'm example2 ");
        });
    }
}
