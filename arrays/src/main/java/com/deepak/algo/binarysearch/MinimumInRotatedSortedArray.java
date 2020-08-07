package com.deepak.algo.binarysearch;

/*
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * Example - 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 */
public class MinimumInRotatedSortedArray {
	
	public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) return nums[0];
        
        int left = 0;
        int right = nums.length-1;
        
        //array is not rotated
        if(nums[left] < nums[right]) {
            return nums[0];
        }
        
        while(left < right) {
            int mid = left + (right-left)/2;
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return nums[mid];
            } else if(nums[left] <= nums[mid] && nums[mid] > nums[right]) { //to filter out sorted part of array
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return nums[left];
    }
}
