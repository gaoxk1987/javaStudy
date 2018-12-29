package com.bceden.string;

import java.lang.reflect.Field;

public class StringTest {
	
public static void main(String[] args) {
	String s0= "Hello World";
	String s1= new String("Hello World".getBytes());
	Field field;
	try {
		field = String.class.getDeclaredField("value");
		field.setAccessible(true);  
		char[] value = (char[])field.get(s0);  
		value[0]='a';
		//打印出s1和s0的值是分别是什么?
	} catch (Exception e) {
		e.printStackTrace();
	}  
	System.out.println(s0);
	System.out.println(s1);
	
	System.out.println("------------------------------");
	
	String a ="aaa";
//	a="bbb";
//	a = new String("bbb");
	try {
		 Field field1 =String.class.getDeclaredField("value");
		 field1.setAccessible(true);
		 char[] value1 = (char[])field1.get(a);
		 value1[0]='b';
		 value1[1]='b';
		 value1[2]='b';
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	System.out.println(a);
}
}
