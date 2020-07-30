package com.deepak.algo.arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	
	//Time complexity O(n)
    //Space complexity O(n)
    public int majorityElement_2(int[] nums) {
        
        if(nums.length == 1)
            return nums[0];
        
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int count = map.get(nums[i]);
                if((count+1) >len/2)
                    return nums[i];
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        } 
        
        return -1;
    }
    
    //Moore's voting algorithm
    //Time complexity O(n)
    //Space Complexity O(1)
    public int majorityElement(int[] nums) {
        int result = 0; //take index 0 as result to start with
        int count = 1;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[result] == nums[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                count = 1;
                result = i;
            }
        }
        
        return nums[result];
    }

}
