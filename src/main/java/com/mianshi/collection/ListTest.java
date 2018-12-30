package com.mianshi.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		//内部原理：object数组  初始容量10   如何扩容1.5+1
		List list = new ArrayList();
		List list1 = new ArrayList(20);
		
		int maxValue =Math.max(2,4);
		
		//Arrays.sort实现原理和Collection实现原理
		List<Integer> sortIntList = new ArrayList<Integer>(10);
		sortIntList.add(66);
		sortIntList.add(12);
		sortIntList.add(22);
		sortIntList.add(3);
		sortIntList.add(44);
		sortIntList.add(6);
		sortIntList.add(99);
		
		Collections.sort(sortIntList);
		for (Iterator iterator = sortIntList.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		

	}

}
