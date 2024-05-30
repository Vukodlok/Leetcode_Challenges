/*
* Leetcode Challenge: Valid Anagram
*
* Given two strings s and t, return true if t is an anagram of s, and false otherwise.
*
* An Anagram is a word or phrase formed by rearranging the letters of a different word or * phrase, typically using all the original letters exactly once.
*
* 5/30/24
* Mark Robuck
*/
import java.util.HashMap;

class Solution {
    /*
    * Determine if one string is an anagram of another.
    *
    * @params s, string tested on
    * @params t, string to be tested
    * @return true if t is an anagram of s, false otherwise
    */
    public boolean isAnagram(String s, String t) {
        //check for equal length
        if (s.length() != t.length()) {
            return false;
        }
        //create a hashmap for each string to count occurrences of letters
        HashMap<Character, Integer> countS = new HashMap<>();
        HashMap<Character, Integer> countT = new HashMap<>();
        //convert strings to arrays and add a letter count to the respective hashmaps
        for (char c : s.toCharArray()) {
            countS.put(c, countS.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        //check if hashmaps are equivalent
        return countS.equals(countT);
    }
}
/* I used the more optimal solutions from my python attempt to try an alternate solution here in Java with hashmaps.
When looking through more efficient solutions it turned out my thought process for python would have been more
efficient in Java, and my Java methodology more efficient in python. */
