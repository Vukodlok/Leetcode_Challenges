/*
* Leetcode Challenge: Word Break
*
* Given a string s and a dictionary of strings wordDict, 
* return true if s can be segmented into a space-separated sequence 
* of one or more dictionary words.
*
* Note that the same word in the dictionary may be reused multiple 
* times in the segmentation.
*
* 9/25/24
* Mark Robuck
*/
import java.util.List;
import java.util.Set;
import java.util.HashSet;

class Solution {
    /*
    * Determine if a string can be made from strings in a dictionary.
    * @params s, string to break up
    * @params wordDict, dictionary of string parts
    * @return true if s can be made up of strings from wordDict
    */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); 
        boolean[] dp = new boolean[s.length() + 1];
        //base case: an empty string can be segmented
        dp[0] = true;  
        
        //iterate over the string
        for (int i = 1; i <= s.length(); i++) {
            //check each substring from the start to the current position
            for (int j = 0; j < i; j++) {
                //if substring is in wordDict and substring before is valid
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
