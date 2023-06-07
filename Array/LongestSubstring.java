/** Longest Substring without repeating characters */
/**
Question 
Given a String str, find the length of the longest substring without repeating 
characters.

Soln
- Substring: A sequence of contiguous characters that lie within a String.
*/
import java.util.Map;
import java.util.HashMap;

public class LongestSubstring{
    public static int longestSub(String s){
        
        int maxLength = 0;
        int start = 0;
        int end = 0;
        Map<Character,Integer> mychars = new HashMap<>();

        for(; end < s.length(); end++){
            if(mychars.containsKey(s.charAt(end))){
                // start is updated only when a key already exists and we need to begin 
                // counting later substrings so we reset start to the begining of the new substring
                // start is set to the max of start or the index after the last occurence
                // of our current repeated character. 
                // This is because if our current character was repeated but there was
                // another character also previously repeated before our current charachter,
                // then start will definitely be greater than the index stored in our 
                // map for the current repeated character at the end index.
                // this makes sure start is at the position where our new substring begins
                start = Math.max(start,Math.max(start,mychars.get(s.charAt(end))+1));
            }

        mychars.put(s.charAt(end),end);
        // end - start + 1 gives the length of the current substring
        maxLength = Math.max(maxLength,(end-start+1));
        }

        return maxLength;
 
    }
    public static void main(String[] args){
        System.out.println(LongestSubstring.longestSub("pwwkew"));
    }
}