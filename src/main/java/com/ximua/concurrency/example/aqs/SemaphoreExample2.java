package com.ximua.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample2 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for(int i = 0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    //一次获取3个许可
                    semaphore.acquire(3);
                    //需要做并发控制的地方
                    test(threadNum);
                    semaphore.release(3);
                } catch (Exception e) {
                    log.error("exception",e);
                }finally {
                }
            });
        }
        executorService.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{}",threadNum);
    }
}
