package com.selfActualization.concurrent.countdownlatch.self;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainThread {
	private static CountDownLatch latch = new CountDownLatch(3);
	
	public static void main(String[] args) {
		//主进程
		List<TaskAbstract> taList = new ArrayList<TaskAbstract>(3); 
		taList.add(new CacheTaskDetect(latch));
		taList.add(new DabaseTaskDetect(latch));
		taList.add(new NetworkTaskDetect(latch));
		
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < taList.size(); i++) {
			fixedThreadPool.submit(taList.get(i));
		}
		try {
			latch.await();
			
			System.out.println("都已检测完成，执行主进程！");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
}
