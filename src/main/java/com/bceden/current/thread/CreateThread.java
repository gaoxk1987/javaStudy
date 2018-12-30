package com.bceden.current.thread;

/**
 * 创建线程时一定要设置线程名称
 * @author HK
 *
 */
public class CreateThread {

	
	public static void main(String[] args) {
		//方法1
		Thread newThread = new Thread("我是线程1"){
			@Override
			public void run() {
				super.run();
			}
		};
		
		//方法二
		Thread newThread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, "我是线程2");
		
		//方法3
//		MyThread thread = new MyThread ();
//		thread.start();
//		
		
		//方法4 ：传入任务
//		Thread thread = new Thread(task); // 传入任务
//		thread.setName(“thread name");
//		thread.start();
//		
//		Thread thread = new Thread(task, “thread name");
//		thread.start();
	
		
		
	}
	
	class MyThread extends Thread{
		public MyThread() {
			super("我是线程3");
		}
		@Override
		public void run() {
			//doxx
		}
	}
}
