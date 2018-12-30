package com.bceden.guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.util.concurrent.RateLimiter;

public class GuavaRateLimiterTest {

    private int permitsPerSecond = 5; //每秒55个许可
    private int threadNum = 20;

    public static void main(String[] args) {

        new GuavaRateLimiterTest().call();
    }

    private void call() {

        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        final RateLimiter rateLimiter = RateLimiter.create(permitsPerSecond); 
        for (int i=0; i<threadNum; i++) {
            executor.execute(new ApiCallTask(rateLimiter));
        }

        executor.shutdown();
    }
}

class ApiCallTask implements Runnable{
    private RateLimiter rateLimiter;
    private boolean runing = true;
    private AtomicInteger atominteger= new AtomicInteger(0);
    public ApiCallTask(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    @Override
    public void run() {

        while(runing){
            rateLimiter.acquire(); // may wait
            getData();
        }
    }

    /**模拟调用合作伙伴API接口*/
    private void getData(){
    	int incrementAndGet = atominteger.incrementAndGet();
        System.out.println(Thread.currentThread().getName()+" runing开始!"+incrementAndGet);
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        incrementAndGet = atominteger.decrementAndGet();
        System.out.println(Thread.currentThread().getName()+" runing结束!"+incrementAndGet);
    }
}