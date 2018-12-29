package com.selfActualization.concurrent.countdownlatch.self;

import java.util.concurrent.CountDownLatch;

public abstract class TaskAbstract implements Runnable {
	private CountDownLatch latch;
	
	public TaskAbstract(CountDownLatch latch) {
		super();
		this.latch = latch;
	}

	@Override
	public void run() {
		executeTask(latch);
	}

	protected abstract void executeTask(CountDownLatch latch);
}
