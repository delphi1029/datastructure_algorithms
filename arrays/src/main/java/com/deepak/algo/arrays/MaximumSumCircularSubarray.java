package com.deepak.algo.arrays;

/*
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * Here, a circular array means the end of the array connects to the beginning of the array.  
 * (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * Also, a subarray may only include each element of the fixed buffer A at most once.  
 * (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * 
 */
public class MaximumSumCircularSubarray {
	
	
	//This solution is brute force, Time complexity O(n^2)
	public int maxSubarraySumCircular_2(int[] A) {
        int max = A[0];
        int len = A.length;
        
        for(int i=0; i<len; i++) {
            int currSum = A[i];
            int currMax = A[i];
            
            for(int j=1; j<len; j++) {
                int idx = (i+j) % len;
                currSum = currSum+A[idx];
                currMax = Math.max(currMax,currSum);
            }
            
            max = Math.max(max,currMax);
        }
        
        return max;
    }
	
	//This is an efficient solution with time complexity O(n)
	public int maxSubarraySumCircular(int[] A) {
        int max = A[0];
        int sum = A[0];
        
        //find max sum subarray using Kadane's algorithm
        for(int i=1; i<A.length; i++) {
            sum = Math.max(A[i], sum+A[i]);
            max = Math.max(sum,max);
        }
        
       //corner case (if all numbers in the array are -ve)
        if(max < 0)
            return max;
        
        
        //find min sum subarray using Kadane's algorithm
        int min = A[0];
         sum = A[0];
        
        for(int i=1; i<A.length; i++) {
            sum = Math.min(A[i],A[i]+sum);
            min = Math.min(min,sum);
        }
        
        //find total sum of the array
        int total = 0;
        for(int i=0; i<A.length; i++) {
            total = total + A[i];
        }
        
        
        //result
        return Math.max(max,total-min);
        
    }

}
