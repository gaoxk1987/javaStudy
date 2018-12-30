package com.selfActualization.timeout;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class TimeOutTest {
	
	public static void main(String[] args) {
//		ExecutorService pool = Executors.newSingleThreadExecutor();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Callable<String> c = new MyCallable("参数1",7000);
		Future<String> f = pool.submit(c);
		try {
			System.out.println(f.get(3000, TimeUnit.MILLISECONDS));
		} catch (Exception e) {
			System.out.println("啦啦啦超时喽！--");
			e.printStackTrace();
			boolean cancelResult = f.cancel(true);
			System.out.println("暂停任务成功了么？"+cancelResult);
//			pool.shutdown();
		}
		
		Callable<String> c2 = new MyCallable("参数2",2000);
		Future<String> f2 = pool.submit(c2);
		try {
			System.out.println(f2.get(3000, TimeUnit.MILLISECONDS));
		} catch (Exception e) {
			System.out.println("f2啦啦啦超时喽！--");
			e.printStackTrace();
			boolean cancelResult = f2.cancel(true);
			System.out.println("暂停任务成功了么？"+cancelResult);
//			pool.shutdown();
		}
		
		pool.shutdown();
	}
}