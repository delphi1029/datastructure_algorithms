package com.deepak.algo.arrays.slidingwindow;

/*
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * Return the length of the longest (contiguous) subarray that contains only 1s. 
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 * Explanation: 
 * [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 * 
 */
public class MaxConsecutiveOnes {

	public int longestOnes(int[] A, int K) {
        int start = 0;
        int end = 0;
        int max = 0;
        
        while(end < A.length) {
            
            if(A[end] == 0) {
                K--;
            }
            
            while(K < 0) {
                if(A[start] == 0) {
                    K++;
                }
                start++;
            }
            
            max = Math.max(max,end-start+1);
            end++;
        }
        
        return max;
    }
}
