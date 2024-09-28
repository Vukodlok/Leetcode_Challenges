/*
* Leetcode Challenge: Edit Distance
*
* Given two strings word1 and word2, return the minimum number 
* of operations required to convert word1 to word2.
*
* You have the following three operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
* 9/28/24
* Mark Robuck
*/

class Solution {
    /*
    * Find minimum number of operations to convert word1 into word2.
    * @params word1, starting word
    * @params word2, ending word
    * @return minimum number of operations to convert word1 into word2
    */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //initialize a 2D DP array
        int[][] dp = new int[m + 1][n + 1];
        
        //base case: converting empty string to any string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        
        //fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //no change needed if the characters are the same
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], //delete
                                            Math.min(dp[i][j - 1], //insert
                                                     dp[i - 1][j - 1])); //replace
                }
            }
        }
        
        return dp[m][n];
    }
}
