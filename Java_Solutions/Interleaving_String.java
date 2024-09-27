/*
* Leetcode Challenge: Interleaving String
*
* Given strings s1, s2, and s3, find whether s3 is formed by 
* an interleaving of s1 and s2.
*
* An interleaving of two strings s and t is a configuration where 
* s and t are divided into n and m substrings respectively, such that:
*
* s = s1 + s2 + ... + sn
* t = t1 + t2 + ... + tm
* |n - m| <= 1
* The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... 
* or t1 + s1 + t2 + s2 + t3 + s3 + ...
*
* Note: a + b is the concatenation of strings a and b.
*
* 9/27/24
* Mark Robuck
*/

class Solution {
    /*
    * Can a string be formed by weaving two other strings together.
    * @oarams s1, given substring
    * @params s2, given substring
    * @params s3, interleaving string formed with s1 and s2
    * @return true if s3 can be made of s1 and s2, false otherwise
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        //base case: if lengths of s1 + s2 don't match s3, not possible
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        //initialize a 2D DP table
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        //set dp[0][0] to True (empty strings match)
        dp[0][0] = true;
        
        //fill the table
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                //check if the current position can be reached by either s1 or s2
                if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
