
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: обнГ3:06:47
 * Version: 1.0
 *
 */

package com.bceden.pattern.factory;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-9-5 обнГ3:06:47   
 */

public class Test {
	public static void main(String[] args) {
		IWorkFactory aworkFactory = new AWorkFactory();
		IWork awork = aworkFactory.creatWork();
		awork.doWork();
		
		
		IWorkFactory bworkFactory = new BWorkFactory();
		IWork bwork = bworkFactory.creatWork();
		bwork.doWork();
		
	}
}
