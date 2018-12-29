
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午8:30:01
 * Version: 1.0
 *
 */

package com.bceden.aop;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-4 下午8:30:01   
 */

public class Logger {
		public static void before() {
		         System.out.println("开始了");
		     }
		     public static void after() {
		         System.out.println("结束了");
		     }

}
