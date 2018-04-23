package com.ximua.concurrency.example.atomic;

import com.ximua.concurrency.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
public class atomicBooleanTest {
    private static AtomicBoolean isHappened = new AtomicBoolean(false);

    public static int clienttotal = 5000;
    public static int threadTotal = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clienttotal);
        for(int i =0 ;i<clienttotal;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    test();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        System.out.println(isHappened.get());
    }

    //只执行了一次
    public static void test(){
        if(isHappened.compareAndSet(false,true)){
            System.out.println("execute");
        }
    }
}
