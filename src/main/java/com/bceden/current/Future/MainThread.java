
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午1:47:04
 * Version: 1.0
 *
 */

package com.bceden.current.Future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-20 下午1:47:04
 */

public class MainThread {

    /**
     *
     * @author Gao xingkun
     * @version 1.0
     * @date 2014-6-20 下午1:47:04
     * @param args void
     * @throws ExecutionException
     * @throws InterruptedException
     */

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        DataProcessThread dataProcessThread = new DataProcessThread();
        FutureTask<String> future = new FutureTask<String>(dataProcessThread);

        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);

        Thread.sleep(10000);//模拟继续处理自身其他业务
        while (true) {
            if (future.isDone()) {
                System.out.println(future.get());
                break;
            }
        }
        executor.shutdown();
    }

}
