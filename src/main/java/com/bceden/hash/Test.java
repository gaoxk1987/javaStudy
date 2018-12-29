
/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午6:07:07
 * Version: 1.0
 *
 */

package com.bceden.hash;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-15 下午6:07:07   
 */

public class Test {
	 public static void main(String[] args) {   
//		 	testHashMap();//原生map
		 	testMyMap();//自己的map
//		 	BitSet bs = new BitSet();
//		 	bs.set(12);
//		 	bs.get(12)
	    }   
	 
	 public static void testHashMap(){
		   Map< String, String> mm = new HashMap< String, String>();    
	        Long aBeginTime=System.currentTimeMillis();//记录BeginTime   
	        for(int i=0;i< 1000000;i++){   
	        mm.put(""+i, ""+i*100);   
	        }   
	        Long aEndTime=System.currentTimeMillis();//记录EndTime   
	        System.out.println("insert time-->"+(aEndTime-aBeginTime));   
	           
	        Long lBeginTime=System.currentTimeMillis();//记录BeginTime   
	        mm.get(""+100000);   
	        Long lEndTime=System.currentTimeMillis();//记录EndTime   
	        System.out.println("seach time--->"+(lEndTime-lBeginTime));   
	 }
	 
	 public static void testMyMap(){
		  MyMap< String, String> mm = new MyMap< String, String>();    
	        Long aBeginTime=System.currentTimeMillis();//记录BeginTime   
	        for(int i=0;i< 1000000;i++){   
	        mm.put(""+i, ""+i*100);   
	        }   
	        Long aEndTime=System.currentTimeMillis();//记录EndTime   
	        System.out.println("insert time-->"+(aEndTime-aBeginTime));   
	           
	        Long lBeginTime=System.currentTimeMillis();//记录BeginTime   
	        mm.get(""+100000);   
	        Long lEndTime=System.currentTimeMillis();//记录EndTime   
	        System.out.println("seach time--->"+(lEndTime-lBeginTime));   
	 }
}
