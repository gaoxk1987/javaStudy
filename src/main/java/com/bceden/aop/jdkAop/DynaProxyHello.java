
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午8:31:49
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
 * @date 2014-6-4 下午8:31:49
 */

public class DynaProxyHello implements InvocationHandler {

    private Object delegate;//被代理的对象

    public DynaProxyHello(Object delegate) {
        this.delegate = delegate;
    }
    @SuppressWarnings("unused")
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // TODO Auto-generated method stub
        Object result = null;
        try {
            // 执行原来的方法之前记录日志
            Logger.before();
            if(true) return null;
            // JVM通过这条语句执行原来的方法(反射机制)
            result = method.invoke(this.delegate, args);
            // 执行原来的方法之后记录日志
            Logger.after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回方法返回值给调用者
        return result;
    }

}
