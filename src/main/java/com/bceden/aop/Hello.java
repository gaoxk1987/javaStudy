
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: обнГ8:28:39
 * Version: 1.0
 *
 */

package com.bceden.aop;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-4 обнГ8:28:39   
 */

public class Hello implements IHello { 
	
	public void sayGoogBye(String name) {
    System.out.println(name+" GoodBye!");
	}
	public void sayHello(String name) {
	    System.out.println("Hello " + name);
	}
}
