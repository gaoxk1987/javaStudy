package com.selfActualization.concurrent.countdownlatch.self;

import java.util.concurrent.CountDownLatch;

public class DabaseTaskDetect extends TaskAbstract {

	public DabaseTaskDetect(CountDownLatch latch) {
		super(latch);
	}

	@Override
	protected void executeTask(CountDownLatch latch) {
		System.out.println("������ݿ�ɹ���");
		latch.countDown();
	}

}
