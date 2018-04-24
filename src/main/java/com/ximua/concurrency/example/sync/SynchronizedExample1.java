package com.ximua.concurrency.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedExample1 {

    //修饰代码块
    public void test1(String j){
        synchronized(this){
            for(int i =0;i<20;i++){
                System.out.println(j+" = "+i);
            }
        }
    }

    //修饰一个方法
    public synchronized void test2(String j){
        for(int i =0;i<20;i++){
            System.out.println(j+" = "+i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            example1.test2("我是example2-1 ");
        });
        executorService.execute(()->{
            example2.test2("我是example2-2");
        });
    }
}
