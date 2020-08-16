package com.deepak.algo.matrix;

/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example - 
 *  Input:
 *   matrix = [
 *    [1,   3,  5,  7],
 *    [10, 11, 16, 20],
 *    [23, 30, 34, 50]
 *   ]
 *  target = 3
 *  Output: true
 * 
 * 
 */
public class Search2DMatrix {
	
public boolean searchMatrix(int[][] matrix, int target) {
        
        int rows = matrix.length;       
        int cols = matrix[0].length;
        
       int left = 0;
        int right = rows * cols - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            int midElement = matrix[mid / cols][mid % cols];
            
            if(midElement == target) {
               return true; 
            } else if(midElement > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return false;
    }

}
