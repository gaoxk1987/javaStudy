package com.selfActualization.concurrent.countdownlatch.self;

import java.util.concurrent.CountDownLatch;

public class NetworkTaskDetect extends TaskAbstract {

	public NetworkTaskDetect(CountDownLatch latch) {
		super(latch);
	}

	@Override
	protected void executeTask(CountDownLatch latch) {
		System.out.println("�������ɹ���");
		latch.countDown();
	}

}
