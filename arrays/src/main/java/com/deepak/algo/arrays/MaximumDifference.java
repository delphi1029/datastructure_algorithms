package com.deepak.algo.arrays;

/*
 * Find maximum value of a[j]-a[i] such that j>1
 * 
 * Ex - {2, 3, 10, 6, 4, 8, 1}
 * 
 * o/p - 8  (10-2) 
 * 
 */
public class MaximumDifference {
	
	public static int maxDiff(int[] arr) {
		
		int min = arr[0];
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i=1; i<arr.length; i++) {
			maxDiff = Math.max(maxDiff,  arr[i]-min);
			min = Math.min(min,  arr[i]);
		}
		
		return maxDiff;
	}
	
	public static void main(String[] args) {
		int[] a = {2,3,10,6,4,8,1};
		
		System.out.print(maxDiff(a));
	}

}
