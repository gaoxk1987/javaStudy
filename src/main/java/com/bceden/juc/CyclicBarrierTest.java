
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:25:48
 * Version: 1.0
 *
 */

package com.bceden.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** *//** 
 * CyclicBarrier类似于CountDownLatch也是个计数器， 
 * 不同的是CyclicBarrier数的是调用了CyclicBarrier.await()进入等待的线程数， 
 * 当线程数达到了CyclicBarrier初始时规定的数目时，所有进入等待状态的线程被唤醒并继续。 
 * CyclicBarrier就象它名字的意思一样，可看成是个障碍， 
 * 所有的线程必须到齐后才能一起通过这个障碍。 
 * CyclicBarrier初始时还可带一个Runnable的参数， 
 * 此Runnable任务在CyclicBarrier的数目达到后，所有其它线程被唤醒前被执行。 
 */  
public class CyclicBarrierTest {
	
	static class ComponentThread implements Runnable{
			int  ID;
			int[] array;
			CyclicBarrier barrier;
		
		
		public ComponentThread(int iD, int[] array, CyclicBarrier barrier) {
				super();
				ID = iD;
				this.array = array;
				this.barrier = barrier;
			}


		@Override
		public void run() {
			 array[ID] = new Random().nextInt(100);  
             System.out.println("Component " + ID + " generates: " + array[ID]);  
             // 在这里等待Barrier处  
             System.out.println("Component " + ID + " sleep");  
             try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}  
             System.out.println("Component " + ID + " awaked");  
             // 计算数据数组中的当前值和后续值  
             int result = array[ID] + array[ID + 1];  
             System.out.println("Component " + ID + " result: " + result);  
		}
		
	}
	
	/** *//** 
     * 测试CyclicBarrier的用法 
     */  
    public  static void testCyclicBarrier() {  
        final int[] array = new int[3];  
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {  
            // 在所有线程都到达Barrier时执行  
            public void run() {  
                System.out.println("testCyclicBarrier run");  
                array[2] = array[0] + array[1];  
            }  
        });  
  
        // 启动线程  
        new Thread(new ComponentThread(0, array,barrier)).start();  
        new Thread(new ComponentThread(1, array,barrier)).start();  
    }  
	public static void main(String[] args) {
		  CyclicBarrierTest.testCyclicBarrier();
	}

}
