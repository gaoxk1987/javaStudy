
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����8:31:49
 * Version: 1.0
 *
 */

package com.bceden.aop.jdkAop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.bceden.aop.Logger;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-4 ����8:31:49   
 */

public class DynaProxyHello implements InvocationHandler {

	 private Object delegate;//������Ķ���
	   
	      public DynaProxyHello(Object delegate) {
	          this.delegate = delegate;
	      }
	      @SuppressWarnings("unused")
		public Object invoke(Object proxy, Method method, Object[] args)
	              throws Throwable {
	          // TODO Auto-generated method stub
	          Object result = null;
	          try {
	              // ִ��ԭ���ķ���֮ǰ��¼��־
	              Logger.before();
	              if(true) return null;
	              // JVMͨ���������ִ��ԭ���ķ���(�������)
	              result = method.invoke(this.delegate, args);
	              // ִ��ԭ���ķ���֮���¼��־
	              Logger.after();
	          } catch (Exception e) {
	              e.printStackTrace();
	          }
	          // ���ط�������ֵ��������
	          return result;
	      }

}
