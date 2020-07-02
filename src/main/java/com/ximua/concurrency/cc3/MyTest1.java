package com.ximua.concurrency.cc3;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2020-07-01 08:45
 */
public class MyTest1 {
    private Object obj = new Object();

    public void method() {
        synchronized (obj){
            System.out.println("hello world");
            throw new RuntimeException();
        }
    }

    public void method2(){
        synchronized (obj){
            System.out.println("welcome");
        }
    }
}