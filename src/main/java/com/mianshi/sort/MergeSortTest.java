package com.mianshi.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSortTest {

	public static void main(String[] args) {
//		List<Object> list = new ArrayList<Object>();
		Object[] obj ={2,58,63,84,75};
		MergeSort.legacyMergeSort(obj);
		printArray(obj);
	}

	
	public static void printArray(Object[] obj){
		for (int i = 0; i < obj.length; i++) {
			System.out.print(obj[i]+" ");
		}
	}
}
