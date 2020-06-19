package com.ximua.concurrency.test.wait2notify;

/**
 * @author qiankeqin
 * @Description: DESCRIPTION
 * @date 2020-06-17 17:19
 */
public class TClient {
    public static void main(String[] args) {
        MyObject obj = new MyObject();
        IncreaseThread ti = new IncreaseThread(obj);
        DecreaseThread tc = new DecreaseThread(obj);
        ti.start();
        tc.start();
    }
}