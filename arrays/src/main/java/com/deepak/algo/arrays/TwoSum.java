package com.deepak.algo.arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 */
public class TwoSum {
	
	// If the input array is NOT sorted use this
	//Time complexity of this solution is O(n)
	// space complexity is also O(n)
	public int[] twoSum(int[] nums, int target) {
        
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            
            if(map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            
            map.put(nums[i],i);
        }
        
        return null;
        
    }
	
	
	// If the input array is sorted use this
	//Time complexity of this solution is O(n)
	// space complexity is also O(1)
	public int[] twoSum_1(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        
        while(start < end) {
            if((nums[start] + nums[end]) == target) {
                return new int[]{start,end};
            } else if((nums[start] + nums[end]) > target) {
                end--;
            } else {
                start++;
            }
        }
        
        return null;
    }

}
