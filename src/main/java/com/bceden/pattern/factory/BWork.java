/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午2:54:44
 * Version: 1.0
 *
 */

package com.bceden.pattern.factory;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-9-5 下午2:54:44   
 */

public class BWork implements IWork {

	@Override
	public void doWork() {
		System.out.println("做的是B工作！！！");
	}

}