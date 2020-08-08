package com.deepak.algo.binarysearch;

/*
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * Ex - 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 */
public class SearchInRotatedArray {
	
	// This is one pass algorithm
	//Time complexity is O(log n)
	public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            } else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
        }
        return -1;
	}
	
	
	/*
	 * Algorithm - 
	 *  1) Find pivot element  ie minimum element in sorted array
	 *  2) searh in both the arrays left of pivot and right of pivot
	 *  3) This is a 2 pass algorithm
	 *  4) Time omplexity is O(log n)
	 */
	public int search_1(int[] nums, int target) {
        if(nums.length == 0) return -1;
        if(nums.length == 1) {
            if(nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        } 
        
        int pivot = getPivot(nums);
        System.out.print(pivot);
        int s1 = binarySearh(nums,0,pivot-1,target);
        int s2 = binarySearh(nums,pivot, nums.length-1,target);
        
        if(s1 >= 0)
            return s1;
        else
            return s2;
        
    }
    
    private int binarySearh(int[] nums, int left, int right, int target) {
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        
        return -1;
    }
    // 0 1 2 3 4 5 6
    // 4 5 6 7 0 1 2
    //         ^   ^
    //           ^
    // L R M
    // 0 6 3
    // 4 6 5
    // 4 4 4
    
    private int getPivot(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums[left] < nums[right]) {
            return left;
        }
        
        while(left < right) {
            int mid = left + (right - left)/2;
            
            if(mid > 0 && nums[mid] < nums[mid-1]) {
                return mid;
            } else if(nums[mid] >= nums[left] && nums[mid] > nums[right]) { // to determine unsorted array
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }

}
