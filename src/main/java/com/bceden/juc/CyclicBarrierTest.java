
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����10:25:48
 * Version: 1.0
 *
 */

package com.bceden.juc;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/** *//** 
 * CyclicBarrier������CountDownLatchҲ�Ǹ��������� 
 * ��ͬ����CyclicBarrier�����ǵ�����CyclicBarrier.await()����ȴ����߳����� 
 * ���߳����ﵽ��CyclicBarrier��ʼʱ�涨����Ŀʱ�����н���ȴ�״̬���̱߳����Ѳ������� 
 * CyclicBarrier���������ֵ���˼һ�����ɿ����Ǹ��ϰ��� 
 * ���е��̱߳��뵽������һ��ͨ������ϰ��� 
 * CyclicBarrier��ʼʱ���ɴ�һ��Runnable�Ĳ����� 
 * ��Runnable������CyclicBarrier����Ŀ�ﵽ�����������̱߳�����ǰ��ִ�С� 
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
             // ������ȴ�Barrier��  
             System.out.println("Component " + ID + " sleep");  
             try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}  
             System.out.println("Component " + ID + " awaked");  
             // �������������еĵ�ǰֵ�ͺ���ֵ  
             int result = array[ID] + array[ID + 1];  
             System.out.println("Component " + ID + " result: " + result);  
		}
		
	}
	
	/** *//** 
     * ����CyclicBarrier���÷� 
     */  
    public  static void testCyclicBarrier() {  
        final int[] array = new int[3];  
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {  
            // �������̶߳�����Barrierʱִ��  
            public void run() {  
                System.out.println("testCyclicBarrier run");  
                array[2] = array[0] + array[1];  
            }  
        });  
  
        // �����߳�  
        new Thread(new ComponentThread(0, array,barrier)).start();  
        new Thread(new ComponentThread(1, array,barrier)).start();  
    }  
	public static void main(String[] args) {
		  CyclicBarrierTest.testCyclicBarrier();
	}

}
