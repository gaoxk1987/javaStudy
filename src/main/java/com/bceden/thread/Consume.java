package com.bceden.thread;

import java.util.List;

public class Consume implements Runnable {

	private List container = null;
	private int count;

	public Consume(List lst) {
		this.container = lst;
	}

	public void run() {
		while (true) {
			synchronized (container) {
				if (container.size() == 0) {
					try {
						container.wait();// ����Ϊ�գ����������ȴ�����
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				container.remove(0);
				container.notify();
				System.out.println("�ҳ���" + (++count) + "��");
			}
		}
	}

}
