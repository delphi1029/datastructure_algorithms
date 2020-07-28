package com.deepak.algo.arrays;

/*
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Follow up:
 * 
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 * 
 * 
 * 
 */
public class RotateTheArray {
	
	/*
	 * Time complexity of this solution is O(n+k) ~ O(n)
	 * Space complexity is O(k)
	 */
	public void rotate(int[] nums, int k) {
        
        //if k is greater the length of rthe array
        if(k > nums.length) {
          k = k-nums.length;  
        }
        
        // create a temp array to store k numbers
        int[] temp = new int[k];
        int x = 0;
        for(int i=nums.length-k; i<nums.length; i++) {
            temp[x] = nums[i];
            x++;
        }
        
        //shift remaining numbers by k positions
        for(int i=nums.length-1; i>=k; i--) {
            nums[i] = nums[i-k];
        } 
        
        //copy k numbers from temp to array
        for(int i=0; i<temp.length;i++) {
            nums[i] = temp[i];
        }
    }
	
	/*
	 * This is non-intuitive solution having time complexity O(n)
	 *  and space complexity O(1)
	 */
	public void rotate_1(int[] nums, int k) {
       k = k % nums.length;
       reverse(nums, 0, nums.length-1);
       reverse(nums, 0, k-1);
       reverse(nums, k , nums.length-1);
       
    }
	
	public void reverse(int[] arr, int low, int high) {
		while(low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

}
