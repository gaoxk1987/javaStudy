package com.selfActualization.concurrent.countdownlatch.self;

import java.util.concurrent.CountDownLatch;

public class CacheTaskDetect extends TaskAbstract {

	public CacheTaskDetect(CountDownLatch latch) {
		super(latch);
	}

	@Override
	protected void executeTask(CountDownLatch latch) {
		System.out.println("¼ì²â»º´æ³É¹¦£¡");
		latch.countDown();
	}

}
