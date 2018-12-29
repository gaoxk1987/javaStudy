/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����5:15:50
 * Version: 1.0
 *
 */

package com.bceden.current.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-26 ����5:15:50
 */

public class ScheduledExecutorTest implements Runnable {

	private String jobName = "";

	public ScheduledExecutorTest(String jobName) {
		super();
		this.jobName = jobName;
	}

	@Override
	public void run() {
		System.out.println("execute " + jobName);
	}

	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

		long initialDelay1 = 1;
		long period1 = 1;
		// �����ڿ�ʼ1����֮��ÿ��1����ִ��һ��job1
		service.scheduleAtFixedRate(new ScheduledExecutorTest("job1"),
				initialDelay1, period1, TimeUnit.SECONDS);

		long initialDelay2 = 2;
		long delay2 = 2;
		// �����ڿ�ʼ2����֮��ÿ��2����ִ��һ��job2
		service.scheduleWithFixedDelay(new ScheduledExecutorTest("job2"),
				initialDelay2, delay2, TimeUnit.SECONDS);
	}
}
