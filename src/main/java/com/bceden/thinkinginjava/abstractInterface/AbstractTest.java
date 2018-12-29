
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午5:07:55
 * Version: 1.0
 *
 */

package com.bceden.thinkinginjava.abstractInterface;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-7-7 下午5:07:55   
 */

public abstract class AbstractTest {

	String name ="小白";   //private 变量父类不能访问
	private String password = "234";
	
	abstract String getName();
	
	String getPass(){
		return password;
	};
	
	public static void main(String[] args) {
		AbstractTest at = new SubAstract1();
	
		System.out.println(at.getName());
		System.out.println(at.getPass());
	}
}
