/*
* Leetcode Challenge: Minimum Window Substring
*
* Given two strings s and t of lengths m and n respectively, 
* return the minimum window substring of s such that 
* every character in t (including duplicates) is included in the window. 
* If there is no such substring, return the empty string "".
* The testcases will be generated such that the answer is unique.
*
* 7/17/24
* Mark Robuck
*/
import java.util.HashMap;
import java.util.Map;

class Solution{
    /*
    * find the smallest substring of a string that contains all of certain characters.
    * @params s, string to be searched
    * @params t, string of characters to be found
    * @return minimum substring from s that contains all characters from t
    */
    public String minWindow(String s, String t) {
        // Empty s or t
        if (s.isEmpty() || t.isEmpty()) {
            return "";
        }

        // Create dictionary and pointers for sliding window
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }
        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {Integer.MAX_VALUE, 0, 0}; // (window length, left, right)

        // Filter s with characters only in t
        int[] filteredS = new int[s.length()];
        int filterIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS[filterIndex++] = i;
            }
        }

        // Initialize right pointer and window counts
        while (r < filterIndex) {
            char charAtRight = s.charAt(filteredS[r]);
            windowCounts.put(charAtRight, windowCounts.getOrDefault(charAtRight, 0) + 1);

            if (windowCounts.get(charAtRight).intValue() == dictT.get(charAtRight).intValue()) {
                formed++;
            }

            // Shrink the window from the left
            while (l <= r && formed == required) {
                char charAtLeft = s.charAt(filteredS[l]);
                int end = filteredS[r];
                int start = filteredS[l];

                if (end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(charAtLeft, windowCounts.get(charAtLeft) - 1);
                if (windowCounts.get(charAtLeft).intValue() < dictT.get(charAtLeft).intValue()) {
                    formed--;
                }

                l++;
            }

            // Grow the window from the right
            r++;
        }

        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
