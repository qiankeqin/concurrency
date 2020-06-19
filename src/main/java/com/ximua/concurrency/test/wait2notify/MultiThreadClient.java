package com.ximua.concurrency.test.wait2notify;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2020-06-18 15:56
 */
public class MultiThreadClient {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        IncreaseThread increaseThread = new IncreaseThread(obj);
        IncreaseThread increaseThread1 = new IncreaseThread(obj);
        DecreaseThread decreaseThread = new DecreaseThread(obj);
        DecreaseThread decreaseThread1 = new DecreaseThread(obj);

        increaseThread.start();
        increaseThread1.start();
        decreaseThread.start();
        decreaseThread1.start();
    }
}