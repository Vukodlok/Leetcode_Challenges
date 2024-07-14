/*
* Leetcode Challenge: Longest Substring Without Repeating Characters
*
* Given a string s, find the length of the longest substring 
* without repeating characters.
*
* 7/14/24
* Mark Robuck
*/
import java.util.HashMap;
import java.util.Map;

class Solution{
    /*
    * Find longest substring without repeated characters.
    * @params s, provided string to check
    * @return length of longest substring without repeated characters
    */
    public int lengthOfLongestSubstring(String s) {
        //empty string
        if (s == null || s.length() == 0){
            return 0;
        }
        //hashmap for storing characters from s
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        //loop through s looking for duplicate character in window
        for (int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left){
                //move left pointer to after last occurrance of character
                left = charMap.get(currentChar) + 1;
            }
            //update last character position
            charMap.put(currentChar, right);
            //update max_length and current length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
