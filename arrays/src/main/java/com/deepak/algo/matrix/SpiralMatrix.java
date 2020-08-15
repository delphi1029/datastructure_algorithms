package com.deepak.algo.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	
public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<>();
        if(matrix.length == 0)
            return result;
        
        int top = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int left = 0;
        
       while(top <= bottom && left <= right) {
            //top row
            for(int i = left; i<=right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            //right column
            for(int i=top; i<=bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            
           if(top <= bottom) {
                //bottom line
                for(int i=right; i>=left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
           }
           
           if(left <= right) {
               for(int i=bottom; i>=top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
           }
       }
        
        return result;   
    }

}
