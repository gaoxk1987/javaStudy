package com.bceden.sorting.insertion;

import static com.bceden.utils.SortUtils.arrayToString;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertionSortTest {


	@Test
	public void testInsertionSort() {
		
		String arun="arun",nancy="nancy",jason="jason",daisy="daisy", dani="dani";
		InsertionSort sort=new InsertionSort();
		Comparable[] sortedArray = sort.sort(new String[]{arun,nancy,jason, dani, daisy});
		System.out.println(arrayToString(sortedArray));
		
		Comparable[] sortedInteger = sort.sort(new Integer[]{6,15,2,1});
		System.out.println(arrayToString(sortedInteger));
//		assertEquals("arun:daisy:dani:jason:nancy:",arrayToString(sortedArray));
//		assertEquals("arun : daisy : dani : jason : nancy : ",arrayToString(sortedArray));
	}
}
