
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午3:36:21
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
 * @date 2014-8-20 下午3:36:21
 */

public class CglibProxy implements MethodInterceptor{


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        // TODO Auto-generated method stub
        Object result = null;
        try {
            // 执行原来的方法之前记录日志
            Logger.before();
            // JVM通过这条语句执行原来的方法(反射机制)
            result = methodProxy.invokeSuper(o, args);
            // 执行原来的方法之后记录日志
            Logger.after();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回方法返回值给调用者
        return result;
    }

}
