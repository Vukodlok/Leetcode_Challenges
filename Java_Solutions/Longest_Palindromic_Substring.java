/*
* Leetcode Challenge: Longest Palindromic Substring
*
* Given a string s, return the longest palindromic substring in s.
*
* 9/27/24
* Mark Robuck
*/

class Solution {
    /*
    * Find smallest palindromic substring.
    * @params s, string string to search
    * @return shortest palindromic substring in s
    */
    public String longestPalindrome(String s) {
        //base case: empty string or single character
        if (s.length() == 0) {
            return "";
        }
        
        int start = 0;
        int maxLength = 1;
        
        //expand around each character and each pair of characters
        for (int i = 0; i < s.length(); i++) {
            //odd-length palindromes
            int[] oddPalindrome = expandAroundCenter(s, i, i);
            if (oddPalindrome[1] > maxLength) {
                start = oddPalindrome[0];
                maxLength = oddPalindrome[1];
            }
            //even-length palindromes
            int[] evenPalindrome = expandAroundCenter(s, i, i + 1);
            if (evenPalindrome[1] > maxLength) {
                start = evenPalindrome[0];
                maxLength = evenPalindrome[1];
            }
        }
        
        return s.substring(start, start + maxLength);
    }

    //helper function to expand around center and check for palindrome
    private int[] expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Return the start index and length of the palindrome found
        return new int[]{left + 1, right - left - 1};
    }
}
