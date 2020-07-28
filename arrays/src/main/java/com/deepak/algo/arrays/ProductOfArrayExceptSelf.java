package com.deepak.algo.arrays;

/*
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the 
 * elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * 
 */

public class ProductOfArrayExceptSelf {
	
	/*
	 * we can make use of the product of all the numbers to the left and all the numbers to the right of the index. 
	 * Multiplying these two individual products would give us the desired result as well.
	 * 
	 * Create two arrays Left and right and then multiply them to get the answer
	 */

	public int[] productExceptSelf(int[] nums) {
        
        int[] left = new int[nums.length];
        left[0] = 1;
        
        for(int i=1; i<nums.length; i++) {
            left[i] = nums[i-1] * left[i-1];                   
        }
        
        int[] right = new int[nums.length];
        right[nums.length-1] = 1;
        
        for(int i=nums.length-2; i>=0; i--) {
            right[i] = nums[i+1] * right[i+1];    
        }
        
        for(int i=0; i<nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        
        return nums;
    }
}
