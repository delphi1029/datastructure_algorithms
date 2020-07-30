package com.deepak.algo.arrays;

/*
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * Ex - 
 * Input: [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * 
 */

public class MaximumSumSubarray {
	
	public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        
        for(int i=1; i<nums.length;i++) {
            sum = Math.max((sum + nums[i]),nums[i]);
            max = Math.max(max,sum);
        }
               
    return max;
    }

}
