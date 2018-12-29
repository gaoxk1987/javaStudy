package com.bceden.sorting.insertion;

import static com.bceden.utils.SortUtils.exchange;
import static com.bceden.utils.SortUtils.less;

public class InsertionSort {

	public Comparable[] sort(Comparable[] items) {
		//6 15 2 1  从后往前比较  如果当前值大于已排序的最大值,则跳出内循环
		for (int i = 0; i < items.length; i++) {

			for (int j = i; j > 0; j--) {
				if (less(items[j], items[j - 1])) {
					exchange(items, j, j - 1);
				} else {
					break;
				}
			}

		}

		return items;

	}

}
