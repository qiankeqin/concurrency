package com.ximua.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CyclicBarrierExample3 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
        //最后一个到达await的线程执行这个
        log.info("callback is running "+Thread.currentThread().getId());
    });
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            final int threadNum = i;
            Thread.sleep(1000);//每个请求延时1s
            executorService.execute(()->{
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception",e);
                }
            });
        }

        executorService.shutdown();
    }

    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{}-{} is ready",threadNum,Thread.currentThread().getId());
        try{
            cyclicBarrier.await();
        }catch(Exception ex){
            log.error("{}","BarrierException");
        }
        log.info("{} continue",threadNum);
    }
}
