package com.ximua.concurrency.test.wait2notify;

/**
 * @author qiankeqin
 * @Description: payment
 * @date 2020-06-17 17:01
 */
public class MyObject {

    private int counter;

    public synchronized void increase(){
        while(counter!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter++;

        System.out.print(counter);

        notify();
    }

    public synchronized void decrease(){
        while(counter == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        counter--;

        System.out.print(counter);
        notify();
    }
}