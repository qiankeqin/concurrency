package com.ximua.concurrency.test.wait2notify;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2020-06-17 17:14
 */
public class DecreaseThread extends Thread {
    private MyObject obj;
    public DecreaseThread(MyObject obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i=0; i<30; i++){
            try {
                Thread.sleep((long) (Math.random()*100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            obj.decrease();
        }
    }
}