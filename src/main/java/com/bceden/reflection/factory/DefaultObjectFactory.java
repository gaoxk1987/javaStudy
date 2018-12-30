/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 上午10:26:44
 * Version: 1.0
 *
 */

package com.bceden.reflection.factory;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-23 上午10:26:44   
 */

public class DefaultObjectFactory implements ObjectFactory {


	public <T> T createObject(Class<T> type) {
		//重用节省代码调用多参数方法
		return createObject(type, null, null);
	}

	public <T> T createObject(Class<T> type,List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		//处理接口的情况
		Class<?> classToCreate = resolveInterface(type);
		@SuppressWarnings("unchecked")
		T created = (T) instantiateClass(classToCreate, constructorArgTypes, constructorArgs);
		return created;
	}

	private <T> T instantiateClass(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
		try {
			Constructor<T> constructor;
			//利用默认构造函数创建对象
			if(constructorArgTypes==null||constructorArgs == null){
				constructor = type.getDeclaredConstructor();
				if(!constructor.isAccessible()){
					constructor.setAccessible(true);
				}
				return constructor.newInstance();
			}
			//性能优化点：constructorArgTypes.toArray(new Class[constructorArgTypes.size()])
			constructor = type.getConstructor(constructorArgTypes.toArray(new Class[constructorArgTypes.size()]));
			if(!constructor.isAccessible()){
				constructor.setAccessible(true);
			}
			return constructor.newInstance(constructorArgs.toArray(new Object[constructorArgs.size()]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Class<?> resolveInterface(Class<?> type) {
		Class<?> classToCreate;
		if (type == List.class || type == Collection.class || type == Iterable.class) {
			classToCreate = ArrayList.class;
		} else if (type == Map.class) {
			classToCreate = HashMap.class;
		} else if (type == SortedSet.class) { // issue #510 Collections Support
			classToCreate = TreeSet.class;
		} else if (type == Set.class) {
			classToCreate = HashSet.class;
		} else {
			classToCreate = type;
		}
		return classToCreate;
	}

}