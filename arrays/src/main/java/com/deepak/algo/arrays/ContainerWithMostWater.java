package com.deepak.algo.arrays;

/*
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn 
 * such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.
 * 
 * 
 */
public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        int start = 0;
        int end = height.length-1;
        int max = 0;
        
        while(start < end) {
            if(height[start] > height[end]) {
                int area = height[end] * (end-start);
                max = Math.max(max,area);
                end--;
            } else {
                int area = height[start] * (end-start);
                max = Math.max(max,area);
                start++;
            }
        }
        
        return max;
    }

}
