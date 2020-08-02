package com.deepak.algo.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;


/*
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: T is "ece" which its length is 3.
 * 
 */


public class LongestSubstringWithAtMostKDistinctChars {
	
		public int lengthOfLongestSubstringKDistinct(String s, int k) {
	        
	        int start = 0;
	        int end = 0;
	        int max = 0;
	        
	        Map<Character,Integer> map = new HashMap<>();
	        
	        for(end = 0; end<s.length(); end++) {
	            char c = s.charAt(end);
	            
	            if(map.get(c) == null) {
	                map.put(c,1);
	            } else {
	                map.put(c, map.get(c)+1);
	            }
	            
	            while(map.size() > k) {
	                char x = s.charAt(start);
	                if(map.get(x) == 1) {
	                    map.remove(x);
	                } else {
	                    map.put(x, map.get(x)-1);
	                }
	                start++;
	            }
	            
	            max = Math.max(max,end-start+1);
	            
	        }
	        
	        return max;
	    }

}
