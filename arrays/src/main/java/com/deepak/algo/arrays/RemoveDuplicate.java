package com.deepak.algo.arrays;

/*
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicate {

	public int removeDuplicates(int[] nums) {
        
        int start = 0;
        int end = 0;
        
        for(end=0; end<nums.length; end++) {
            if(nums[start] != nums[end]) {
                start++;
                nums[start] = nums[end];
            }
        }
        
        return start+1;
    }
}
