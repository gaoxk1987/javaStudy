
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午5:10:43
 * Version: 1.0
 *
 */

package com.bceden.thinkinginjava.abstractInterface;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-7-7 下午5:10:43   
 */

public class SubAstract1 extends AbstractTest {

	//父类的抽象方法一定实现
	String getName() {
		return name;//子类可以访问共有变量
	}

//不一定必须实现
String getPass() {
//	return password;  //父类私有变量子类不能访问
	return "123";
}

}
