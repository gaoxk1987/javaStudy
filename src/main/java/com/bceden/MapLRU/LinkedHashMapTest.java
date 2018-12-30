/**
 * Copyright(c) 2000-2013 HC360.COM, All Rights Reserved.
 * Project: javaStudy 
 * Author: Gao xingkun
 * Createdate: 下午2:07:24
 * Version: 1.0
 *
 */

package com.bceden.MapLRU;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @project javaStudy
 * @author Gao xingkun
 * @version 1.0
 * @date 2014-4-23 下午2:07:24   
 */

public class LinkedHashMapTest {

	/**
	 *
	 * @author Gao xingkun
	 * @version 1.0
	 * @date 2014-4-23 下午2:07:24
	 * @param args void
	 */

	public static void main(String[] args) {
		/**
		 * nitialCapacity   初始容量
		 * loadFactor    加载因子，一般是 0.75f
		 * accessOrder   false 基于插入顺序  true  基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU  最近最少被使用的调度算法）
		 *
		 */
//		LinkedHashMap<Integer,String> lhMap = new LinkedHashMap<Integer,String>();
//		lhMap.put(1, "1");
//		lhMap.put(2, "2");
//		lhMap.put(3, "3");
//		lhMap.put(4, "4");
//		lhMap.put(5, "5");
//		
//		Iterator it = lhMap.keySet().iterator();
//		while(it.hasNext()){
//			int curIndext =(Integer)it.next();
//			System.out.println(lhMap.get(curIndext));
//		}
//		
//		System.out.println("-------------------------------------------------------------------------");
//		
//		LinkedHashMap<Integer,String> lhMap2 = new LinkedHashMap<Integer,String>(10,0.75f,true);
//		lhMap2.put(1, "1");
//		lhMap2.put(2, "2");
//		lhMap2.put(3, "3");
//		lhMap2.put(4, "4");
//		lhMap2.put(5, "5");

//		String value = lhMap2.get(4);
//		System.out.println("获取值"+value);

//		for(Iterator<Integer> it2 =lhMap2.keySet().iterator();it2.hasNext();){
//			int curIndext =(Integer)it2.next();
//			System.out.println(lhMap2.get(curIndext));
//		}

		try {
			testTrueMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testTrueMap() throws Exception {
		Map<Integer,Integer> map=new LinkedHashMap<Integer,Integer>(10,0.75f,true);
		map.put(9,3);
		map.put(7,4);
		map.put(5,9);
		map.put(3,4);
		//现在遍历的话顺序肯定是9,7,5,3
		//下面访问了一下9,3这个键值对，输出顺序就变喽~
		map.get(9);
		for(Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();){
			System.out.println(it.next().getKey());
		}

	}

}