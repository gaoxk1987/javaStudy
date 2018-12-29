package com.selfActualization.concurrent.test;

import java.util.Iterator;
import java.util.List;

public class SchedulerReadThread implements Runnable {
	
	

	@Override
	public void run() {
		try {
			while(true){
				System.out.println("线程"+Thread.currentThread().getName()+"----------------获取rechargeVoList开始----------------");
				List<TestVo> rechargeVoList = Configure.getRechargeVoList();
				for (Iterator iterator = rechargeVoList.iterator(); iterator.hasNext();) {
					TestVo testVo = (TestVo) iterator.next();
					System.out.println("线程"+Thread.currentThread().getName()+"输出："+testVo.toString());
				}
				System.out.println("线程"+Thread.currentThread().getName()+"----------------获取rechargeVoList结束----------------");
			
					Thread.currentThread().sleep(500);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
