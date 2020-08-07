package com.deepak.algo.binarysearch;

import java.util.Arrays;

/*
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *  
 *  Example - Input: nums = [5,7,7,8,8,10],
 *   target = 8
 *	 Output: [3,4]
 * 
 */
public class SearchForARange {
	
	public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result,-1);
        
        result[0] = getStartPosition(nums,target);
        result[1] = getEndPosition(nums,target);
        
        return result;
        
    }
    
    private int getStartPosition(int[] nums,int target) {
        int startPos = -1;
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] >= target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
            
            if(nums[mid] == target)
                startPos = mid;
        }   
        return startPos;
    }
    
    private int getEndPosition(int[] nums,int target) {
        int endPos = -1;
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] <= target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
            
            if(nums[mid] == target)
                endPos = mid;
         }
         return endPos;
    }
    

}
