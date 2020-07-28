package com.deepak.algo.arrays;

/*
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * Ex - Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length.
 * 
 */
public class RemoveElement {
	
	//This 2 pointer method gives O(n) solution and also the oredr of elements are preserved.
	// But if elements to be removed are rare then there will be unnecessary copy operations.
	public int removeElement_1(int[] nums, int val) {
        
        int start = 0;
        int end = 0;
        
        for(end = 0;end < nums.length; end++) {
            if(nums[end] != val) {
                nums[start] = nums[end];
                start++;
            }
        }
        
        return start;
    }
	
	
	//This 2 pointer method gives O(n) solution but the order of elements are NOT preserved.
	//If order of elements are not important then it is better to use this method as copy operations will be less.
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length;
        
        while(start<end) {
            if(nums[start] == val) {
                nums[start] = nums[end-1];
                end--;
            } else {
                start++;
            }
        }
        
        //return length
        return end;
    }

}
