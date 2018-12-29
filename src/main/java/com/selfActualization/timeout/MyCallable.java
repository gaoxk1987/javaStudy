package com.selfActualization.timeout;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
	private String param;
	private long sleepTime;
	public MyCallable(String param,long sleepTime) {
		super();
		this.param = param;
		this.sleepTime = sleepTime;
	}
	@Override
	public String call() throws Exception {
		Thread.sleep(sleepTime);
		System.out.println("参数为‘"+param+"’线程苏醒了哦！");
		return this.param;
	}

}