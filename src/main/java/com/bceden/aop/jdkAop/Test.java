
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午8:36:13
 * Version: 1.0
 *
 */

package com.bceden.aop.jdkAop;

import java.lang.reflect.Proxy;

import com.bceden.aop.Hello;
import com.bceden.aop.IHello;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-4 下午8:36:13
 */

public class Test {

    public static void main(String[] args) {
        // ①目标业务类
        IHello target = new Hello();
        // ② 将目标业务类和横切代码编织到一起
        DynaProxyHello handler = new DynaProxyHello(target);
        // 创建代理类
        IHello proxy = (IHello) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //返回目标类的类装载器，保持两个类的类装载器一样
                target.getClass().getInterfaces(), //返回目标类实现的接口，保证组合而成的代理类也实现这些接口
                handler//指派谁去处理方法的对象
        );
        // ④ 操作代理实例
        proxy.sayHello("张三");
        proxy.sayGoogBye("李四");
        proxy.sayHello("张三");
        proxy.sayHello("张三");
        proxy.sayHello("张三");
        proxy.sayHello("张三");
        proxy.sayHello("张三");
        proxy.sayHello("张三");

    }

}
