package com.ximua.concurrency.example.atomic;

import com.ximua.concurrency.annotations.ThreadSafe;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
@ThreadSafe
public class AtomicIntegerFieldUpdaterTest {

    //更新执行的类的某个字段的，字段必须通过volatile修饰，并且非static的
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> updater
            = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class,"count");

    public volatile int count = 100;


    private  static AtomicIntegerFieldUpdaterTest example5 = new AtomicIntegerFieldUpdaterTest();

    public static void main(String[] args) {
        if(updater.compareAndSet(example5,100,120)){
            System.out.println("success update 1");
        }
        if(updater.compareAndSet(example5,100,120)){
            System.out.println("success update 2");
        }else{
            System.out.println("failed");
        }
    }
}
