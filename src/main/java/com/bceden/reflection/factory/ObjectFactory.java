
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:21:37
 * Version: 1.0
 *
 */

package com.bceden.reflection.factory;

import java.util.List;

/**
 * 面向接口编程
 * 反射工厂接口
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-23 上午10:21:37   
 */
public interface ObjectFactory {
	/**
	 * 
	 * 利用默认的构造函数创建一个对象
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 上午10:25:05
	 * @param type
	 * @return T
	 */
	<T> T createObject(Class<T> type);
	
	/**
	 * 利用特定的构造函数和参数值创建对象
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 上午10:37:44
	 * @param type
	 * @param constructorArgTypes
	 * @param constructorArgs
	 * @return T
	 */
	<T> T createObject(Class<T> type,List<Class<?>> constructorArgTypes,List<Object> constructorArgs);
}
