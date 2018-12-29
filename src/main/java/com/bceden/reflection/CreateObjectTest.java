
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: ����10:48:04
 * Version: 1.0
 *
 */

package com.bceden.reflection;

import java.util.ArrayList;
import java.util.List;

import com.bceden.reflection.factory.DefaultObjectFactory;
import com.bceden.reflection.factory.ObjectFactory;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-6-23 ����10:48:04   
 */

public class CreateObjectTest {

	/**
	 * Ĭ�Ϲ��캯����������
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 ����10:48:04
	 * @param args void
	 */
	public static void main(String[] args) {
//		ObjectFactory dof = new DefaultObjectFactory();
//		User user= (User)dof.createObject(User.class);
//		System.out.println(user!=null);
		collectionTest();
	}

	
	 
	/**
	 *   ���Է������ɼ��Ͽ�ܣ�����ڲ����ж����͵Ļ�
	 *   ���û���жϵĻ��ᱨ��
	 *   java.lang.NoSuchMethodException: java.util.List.<init>()�쳣
	 *   ��Ϊ���ǽӿ�
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-6-23 ����11:38:54 void
	 */
	public static void collectionTest(){
		ObjectFactory dof = new DefaultObjectFactory();
//		List list= (List)dof.createObject(List.class);
//		System.out.println(list!=null);
		
		List list= (List)dof.createObject(ArrayList.class);
		System.out.println(list!=null);
	 }
}
