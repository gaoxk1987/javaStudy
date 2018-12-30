package com.bceden.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorTest {

	public static void main(String[] args) {
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		fixedThreadPool.submit(new Runnable() {
			
			@Override
			public void run() {
					System.out.println("aaa");
			}
		});
		
		fixedThreadPool.shutdown();

	}

}
