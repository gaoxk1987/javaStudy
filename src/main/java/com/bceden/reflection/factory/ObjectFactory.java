
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����10:21:37
 * Version: 1.0
 *
 */

package com.bceden.reflection.factory;

import java.util.List;

/**
 * ����ӿڱ��
 * ���乤���ӿ�
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-23 ����10:21:37   
 */
public interface ObjectFactory {
	/**
	 * 
	 * ����Ĭ�ϵĹ��캯������һ������
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 ����10:25:05
	 * @param type
	 * @return T
	 */
	<T> T createObject(Class<T> type);
	
	/**
	 * �����ض��Ĺ��캯���Ͳ���ֵ��������
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 ����10:37:44
	 * @param type
	 * @param constructorArgTypes
	 * @param constructorArgs
	 * @return T
	 */
	<T> T createObject(Class<T> type,List<Class<?>> constructorArgTypes,List<Object> constructorArgs);
}
