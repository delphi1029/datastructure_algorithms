package com.deepak.algo.arrays;

public class PlusOne {

public int[] plusOne(int[] digits) {
        
        for(int i=digits.length-1; i>=0; i--) {
            //set all 9 at the end of array to 0
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        
        // we're here because all the digits are nines
            int[] newArray = new int[digits.length+1];
            newArray[0] = 1;
            return newArray;
    }
}
