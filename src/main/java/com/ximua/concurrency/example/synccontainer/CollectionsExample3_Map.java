package com.ximua.concurrency.example.synccontainer;

import com.ximua.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@ThreadSafe
public class CollectionsExample3_Map {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行到线程数
    public static int threadTotal = 200;

    public static int count = 0;

    private static Map<Integer,Integer> list = Collections.synchronizedMap(new HashMap<Integer, Integer>()) ;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for(int i = 0;i < clientTotal; i++){
            final int count = i;
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    addList(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",list.size());

    }


    public static void addList(int i){
        list.put(i,i);
    }
}
