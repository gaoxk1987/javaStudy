
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午1:48:18
 * Version: 1.0
 *
 */

package com.bceden.current.Future;

import java.util.concurrent.Callable;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-20 下午1:48:18
 */

public class DataProcessThread implements Callable<String> {


	/* (non-Javadoc)
	 * @see java.util.concurrent.Callable#call()
	 */

	@Override
	public String call() throws Exception {
		Thread.sleep(10000);//模拟数据处理
		return "数据返回";
	}

}
