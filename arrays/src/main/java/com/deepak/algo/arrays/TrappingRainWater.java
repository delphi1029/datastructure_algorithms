package com.deepak.algo.arrays;

/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * 
 */
public class TrappingRainWater {
	
	/* Time complexity of this solution in O(n) and space compexity is O(n)
	    * Take 2 arrays left and right. Populate these arrays with the max element on the left and right of the index(including that index)
	    * once we have left and right max then we can calculate water stored as
	    *  min(leftMax,rightMax) - height
	    */
	    public int trap(int[] height) {
	        
	        if(height.length == 0)
	            return 0;
	        
	        int[] leftMax = new int[height.length];
	        int[] rightMax = new int[height.length];
	        
	        
	        leftMax[0] = height[0];
	        
	        for(int i=1; i<height.length; i++) {
	            leftMax[i] = Math.max(leftMax[i-1],height[i]);
	        }
	        
	        rightMax[height.length-1] = height[height.length-1];
	        
	        for(int j=height.length-2; j>=0; j--) {
	            rightMax[j] = Math.max(rightMax[j+1],height[j]);
	        }
	        
	        int result = 0;
	        
	        for(int k=1; k<height.length-1;k++) {
	            result = result + Math.min(rightMax[k],leftMax[k]) - height[k];
	        }
	        
	        return result;
	    }
	    
	    
	    /* Time complexity of this solution in O(n^2)
	    * Solution : Run a loop form index 1 to length-2, because water cannot be stored in 1st and  last index.
	    * For every index find max height on left side and maxHeight on right side (please not that we have to include current index also when finding max height on left or right because if current is max then water annot be soted on current index)
	    * to calculate the water at particular index find minimum out of left and right max and subtract height of  that index
	    * This is not an efficient solution
	    */
	   /* public int trap_inefficient_sol(int[] height) {
	    
	        int result = 0;
	        
	        for(int i=1; i<height.length-1; i++) {
	            
	            int leftMax = height[i];
	            
	            //find left max starting from start to i-1
	            for(int j=0; j<i; j++) {
	                leftMax = Math.max(leftMax, height[j]);
	            }
	            
	            int rightMax = height[i];
	            for(int k=i+1; k<height.length; k++) {
	                rightMax = Math.max(rightMax, height[k]);
	            }
	            
	            result = result + Math.min(leftMax,rightMax) - height[i];
	        }
	        
	        return result;
	    }
	*/
}
