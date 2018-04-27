package com.ximua.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExample4 {
    private final static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(3);
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for(int i = 0;i<threadCount;i++){
            final int threadNum = i;
            executorService.execute(()->{
                try {
                    //还有，尝试获取多个许可
                    if(semaphore.tryAcquire(5000,TimeUnit.MICROSECONDS)){ //尝试获取一个许可，并等待一段时间
                        //需要做并发控制的地方
                        test(threadNum);
                        semaphore.release();
                    }
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
