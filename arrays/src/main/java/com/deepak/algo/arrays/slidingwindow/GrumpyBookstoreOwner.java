package com.deepak.algo.arrays.slidingwindow;

/*
 * Today, the bookstore owner has a store open for customers.length minutes.  Every minute, some number of customers (customers[i]) enter the store, 
 * and all those customers leave after the end of that minute.On some minutes, the bookstore owner is grumpy.  
 * If the bookstore owner is grumpy on the i-th minute, grumpy[i] = 1, 
 * otherwise grumpy[i] = 0.  When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise they are satisfied.
 * The bookstore owner knows a secret technique to keep themselves not grumpy for X minutes straight, but can only use it once.
 * Return the maximum number of customers that can be satisfied throughout the day.
 * 
 * 
 * 
 */

public class GrumpyBookstoreOwner {
	
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int max = 0;
        int total = 0;
        
        for(int i=0; i<customers.length; i++) {
            if(grumpy[i] == 0)
                total = total + customers[i];
        }
        
        int start = 0;
        int end = 0;
        
        for(end = 0; end<customers.length; end++) {
            if(grumpy[end] == 1) {
                total = total + customers[end];
            } 
            
            if(end >= X-1) {
                 max = Math.max(max, total);
                if(grumpy[start] == 1) {
                    total = total - customers[start];
                }
                start++;
            }
        }
        
        return max;
    }

}
