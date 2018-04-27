package com.ximua.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExample4 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(()->{
            try{
                reentrantLock.lock();//加入aqs等待队列
                log.info("wait signal");//1
                condition.await();//加入到了第二个队列中,等待信号
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            log.info("get signal");//4
            reentrantLock.unlock();
        }).start();

        new Thread(()->{
            reentrantLock.lock();//加入aqs等待队列中
            log.info("get lock"); //2
            try{
                Thread.sleep(3000);
            }catch(InterruptedException ex){
                ex.printStackTrace();
            }
            condition.signal();//发送信号，此时线程1并没有唤醒，只是又加入到了等待队列中
            log.info("send signal~"); //3
            reentrantLock.unlock();
        }).start();
    }
}
