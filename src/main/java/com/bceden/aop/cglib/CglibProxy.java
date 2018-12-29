
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����3:36:21
 * Version: 1.0
 *
 */

package com.bceden.aop.cglib;

import java.lang.reflect.Method;

import com.bceden.aop.Logger;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-8-20 ����3:36:21   
 */

public class CglibProxy implements MethodInterceptor{

	
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		   // TODO Auto-generated method stub
        Object result = null;
        try {
            // ִ��ԭ���ķ���֮ǰ��¼��־
            Logger.before();
            // JVMͨ���������ִ��ԭ���ķ���(�������)
            result = methodProxy.invokeSuper(o, args);
            // ִ��ԭ���ķ���֮���¼��־
            Logger.after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ���ط�������ֵ��������
        return result;
	}

}
