package com.selfActualization.concurrent.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SchedulerWriteThread implements Runnable {

	@Override
	public void run() {
		
		
		while(true){
			String[] array1 = {"1:1","2:2","3:3","4:4",};
			String[] array2 = {"1:2","2:3","3:4","4:5","5:6","6:7","7:8"};
			String[] array3 = {"1:3","2:4","3:5","4:6","5:7","6:8","7:9","8:10"};
			String[] array4 = {};
			try {
				Thread.currentThread().sleep(1000);
				Map<Integer,String[]> map = new HashMap<Integer,String[]>();
				map.put(1, array1);
				map.put(2, array2);
				map.put(3, array3);
				map.put(4, array4);
				Random random = new Random();
				int key = random.nextInt(4);
				Configure.initRechargeConf(map.get(key));
				
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(0);
			}
		}

	}

}
