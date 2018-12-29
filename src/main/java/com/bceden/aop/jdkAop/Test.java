
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����8:36:13
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
 * @date 2014-6-4 ����8:36:13   
 */

public class Test {
	
	public static void main(String[] args) {
		 // ��Ŀ��ҵ����
		         IHello target = new Hello();
		         // �� ��Ŀ��ҵ����ͺ��д����֯��һ��
		         DynaProxyHello handler = new DynaProxyHello(target);
		         // ����������
		         IHello proxy = (IHello) Proxy.newProxyInstance(
		                                            target.getClass().getClassLoader(), //����Ŀ�������װ�������������������װ����һ��
		                                            target.getClass().getInterfaces(), //����Ŀ����ʵ�ֵĽӿڣ���֤��϶��ɵĴ�����Ҳʵ����Щ�ӿ�
		                                            handler//ָ��˭ȥ�������Ķ���
		                                            );
		         // �� ��������ʵ��
		         proxy.sayHello("����");
		         proxy.sayGoogBye("����");
		         proxy.sayHello("����");
		         proxy.sayHello("����");
		         proxy.sayHello("����");
		         proxy.sayHello("����");
		         proxy.sayHello("����");
		         proxy.sayHello("����");

	}

}
