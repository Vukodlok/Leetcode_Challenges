/*
* Leetcode Challenge: Is Subsequence
*
* Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
*
* A subsequence of a string is a new string that is formed from the original string by
* deleting some (can be none) of the characters without disturbing the relative positions
* of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec"
* is not).
*
* 6/4/24
* Mark Robuck
*/
class Solution {
    /*
    * Determine if all characters in one string are contained in another in order.
    * @params s, the substring being checked for
    * @params t, the string possibly containing s
    * @return true if s is contained in t, false otherwise
    */
    public boolean isSubsequence(String s, String t) {
        //pointer for s
        int sIndex = 0;
        //loop through t, checking for each character in s
        for(int tIndex = 0; tIndex < t.length(); tIndex++) {
            //if the characters match move the sIndex pointer
            if (sIndex < s.length() && t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;
                }
            }
        //if sIndex gets to the end of s, all characters have been found
        return sIndex == s.length();
    }
}
