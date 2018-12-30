/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:48:04
 * Version: 1.0
 *
 */

package com.bceden.reflection;

import java.util.ArrayList;
import java.util.List;

import com.bceden.reflection.factory.DefaultObjectFactory;
import com.bceden.reflection.factory.ObjectFactory;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-23 上午10:48:04   
 */

public class CreateObjectTest {

	/**
	 * 默认构造函数创建对象
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 上午10:48:04
	 * @param args void
	 */
	public static void main(String[] args) {
//		ObjectFactory dof = new DefaultObjectFactory();
//		User user= (User)dof.createObject(User.class);
//		System.out.println(user!=null);
		collectionTest();
	}



	/**
	 *   测试反射生成集合框架，如果内部不判断类型的话
	 *   如果没有判断的话会报：
	 *   java.lang.NoSuchMethodException: java.util.List.<init>()异常
	 *   因为都是接口
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 上午11:38:54 void
	 */
	public static void collectionTest(){
		ObjectFactory dof = new DefaultObjectFactory();
//		List list= (List)dof.createObject(List.class);
//		System.out.println(list!=null);

		List list= (List)dof.createObject(ArrayList.class);
		System.out.println(list!=null);
	}
}