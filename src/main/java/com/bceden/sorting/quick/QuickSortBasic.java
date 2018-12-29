package com.bceden.sorting.quick;

import static com.bceden.utils.SortUtils.exchange;
import static com.bceden.utils.SortUtils.less;
import com.bceden.shuffle.KnuthShuffle;

public class QuickSortBasic {

	public void sort (int[] input){
		
		//KnuthShuffle.shuffle(input);
		sort (input, 0, input.length-1);
	}

	private void sort(int[] input, int lowIndex, int highIndex) {

		if (highIndex<=lowIndex){
			return;
		}
		
		int partIndex=partition (input, lowIndex, highIndex);

		sort (input, lowIndex, partIndex-1);
		sort (input, partIndex+1, highIndex);
	}

	private int partition(int[] input, int lowIndex, int highIndex) {
		
		int i=lowIndex;
		int pivotIndex=lowIndex;
		int j=highIndex+1;
		
		
		while (true){
			/**
			 * 2 4 8 1
			 * 4<2  false
			 * 
			 * 
			 */
			while (less(input[++i], input[pivotIndex])){
				if (i==highIndex) break;
			}
			/**
			 * 2 4 8 1
			 *2<1  false
			 * 
			 * 
			 */
			while (less (input[pivotIndex], input[--j])){
				if (j==lowIndex) break;
			}
				
			if (i>=j) break;
			
			exchange(input, i, j);
			
		}
		
		exchange(input, pivotIndex, j);
		
		return j;
	}
	
}
