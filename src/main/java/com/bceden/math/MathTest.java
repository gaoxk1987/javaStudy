package com.bceden.math;

public class MathTest {

	public static void main(String[] args) {
		System.out.println(Math.sqrt(9));
		System.out.println(Math.pow(3, 3));

		System.out.println(sqrt(9));
		System.out.println(sqrt(9.0));
		
		
		
		
		
		
		
		
		
		
	}
	
	
	/**
	 * 使用二分查找方法
	 * @param x
	 * @return
	 */
	static long sqrt(int x) {
		long i = 0;
		long j = x / 2 + 1;
		while (i <= j) {
			long mid = (i + j) / 2;
			long sq = mid * mid;
			if (sq == x)
				return mid;
			else if (sq < x)
				i = mid + 1;
			else
				j = mid - 1;
		}
		return j;
	}
	
	
	/**
	 * 牛顿法
	 * @param x
	 * @return
	 */
	static double sqrt(double x) {
	    if (x == 0) return 0;
	    double last = 0.0;
	    double res = 1.0;
	    while (res != last)
	    {
	        last = res;
	        res = (res + x / res) / 2;
	    }
	    return res;
	}

}
