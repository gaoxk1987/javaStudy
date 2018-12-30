
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午2:51:03
 * Version: 1.0
 *
 */

package com.bceden.pattern.Observer;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-26 下午2:51:03   
 */

public class Test {

	/**
	 * 
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-8-26 下午2:51:03
	 * @param args void
	 */

	public static void main(String[] args) {
		HeadCounter headCounter = new HeadCounter();
        //注册订阅者
		headCounter.registerObserver(new JobSeeker("Mike"));
		headCounter.registerObserver(new JobSeeker("Chris"));
		headCounter.registerObserver(new JobSeeker("Jeff"));
		//通知所有订阅者有新的工作机会
		headCounter.addJob("Google Job");
		headCounter.addJob("Yahoo Job");
	}

}
