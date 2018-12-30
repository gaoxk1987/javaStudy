
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午8:36:13
 * Version: 1.0
 *
 */

package com.bceden.aop.cglib;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;

import com.bceden.aop.Hello;
import com.bceden.aop.IHello;
import com.bceden.aop.jdkAop.DynaProxyHello;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-4 下午8:36:13
 */

public class Test {

    public static void main(String[] args) {

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Hello.class);
        enhancer.setCallback(new CglibProxy());
        Hello proxy = (Hello)enhancer.create();
        // ④ 操作代理实例
        proxy.sayHello("张三");
        proxy.sayGoogBye("李四");
    }

}
