package com.selfActualization.concurrent.test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SchedulerReadMapThread implements Runnable {
	
	

	@Override
	public void run() {
		try {
			while(true){
				System.out.println("map线程"+Thread.currentThread().getName()+"----------------获取rechargeVoList开始----------------");
				Map<String, String> recharge2amountMap = Configure.getRecharge2amountMap();
				Set<String> keySet = recharge2amountMap.keySet();
				for (Iterator iterator = keySet.iterator(); iterator.hasNext();) {
					String string = (String) iterator.next();
					System.out.println("map线程"+Thread.currentThread().getName()+"输出："+string);
				}
				System.out.println("map线程"+Thread.currentThread().getName()+"----------------获取rechargeVoList结束----------------");
			
				Thread.currentThread().sleep(500);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
