package com.deepak.algo.binarysearch;

/*
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * 
 * Ex - 
 * Input: 4
 * Output: 2
 * 
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
 * 
 */
public class Sqrt {
	
	public int mySqrt(int x) {
        if(x < 2)
            return x;
        
        int left = 1;
        int right = x/2;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            long s = (long)mid * mid;
            if(s == x){
                return mid;
            } else if (s < x) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return right;
    }

}
