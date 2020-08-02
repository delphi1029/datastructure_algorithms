package com.deepak.algo.arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * 
 * Given a string, find the length of the longest substring without repeating characters.
 * Example - 
 * Input: "abcabcbb"
 * Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	
	
	public int lengthOfLongestSubstring(String s) {
		
		int start = 0;
	    int end = 0;
	    Map<Character,Integer> map = new HashMap<>();
	    int max = 0;
	    
	    while(end < s.length()) {

	          char c = s.charAt(end);

	          if(map.containsKey(c)) {
	            start = Math.max(map.get(c)+1,start);
	          } 
	          
	          map.put(c,end);
	          max = Math.max(max,end-start+1);
	          end++;
	      }

	    return max;
	    
	}
	
	
	
	//Alternative implementations
	public int lengthOfLongestSubstring_1(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        int max = 0;
        
        for(end = 0; end<s.length(); end++) {
            char c = s.charAt(end);
            
            while(map.containsKey(c)) {
                char x = s.charAt(start);
                start = map.get(x)+1;
                map.remove(x);
            } 
            map.put(c, end);
            max = Math.max(max,end-start+1);
        }
        
        return max;
    }

}
