package com.selfActualization.concurrent.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {

	public static void main(String[] args) {
		/**
		 * 
		 * 并发读取map和list 测试 
		 * 
		 */
		
		
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		newFixedThreadPool.submit(new SchedulerReadThread());
		newFixedThreadPool.submit(new SchedulerReadThread());
		newFixedThreadPool.submit(new SchedulerReadThread());
		
		ExecutorService newFixedMapThreadPool = Executors.newFixedThreadPool(3);
		newFixedMapThreadPool.submit(new SchedulerReadMapThread());
		newFixedMapThreadPool.submit(new SchedulerReadMapThread());
		newFixedMapThreadPool.submit(new SchedulerReadMapThread());
		
		ExecutorService newFixedWriteThreadPool = Executors.newFixedThreadPool(2);
		newFixedWriteThreadPool.submit(new SchedulerWriteThread());
		newFixedWriteThreadPool.submit(new SchedulerWriteThread());
		
//		System.out.println("0".matches("[1-7]"));
//		System.out.println("-------------");
//		System.out.println("1".matches("[1-7]"));
//		System.out.println("2".matches("[1-7]"));
//		System.out.println("3".matches("[1-7]"));
//		System.out.println("4".matches("[1-7]"));
//		System.out.println("5".matches("[1-7]"));
//		System.out.println("6".matches("[1-7]"));
//		System.out.println("7".matches("[1-7]"));
//		System.out.println("-------------");
//		System.out.println("8".matches("[1-7]"));
//		System.out.println("17".matches("[1-7]"));
//		System.out.println("18".matches("[1-7]"));
//		System.out.println("170".matches("[1-7]"));
		
	}

}
