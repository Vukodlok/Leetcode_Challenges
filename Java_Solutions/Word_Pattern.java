/*
* Leetcode Challenge: Word Pattern
*
* Given a pattern and a string s, find if s follows the same pattern.
* Here follow means a full match, such that there is a bijection between a letter 
* in pattern and a non-empty word in s.
*
* 6/6/24
* Mark Robuck
*/
import java.util.HashMap;

class Solution {
    /*
    * Determine if a string of words follows a given pattern.
    * @params pattern, the pattern to be checked for as a string
    * @params s, the string of words to check
    * @ return, true if s follows pattern, false otherwise
    */
    public boolean wordPattern(String pattern, String s) {
        //create HashMaps dictionaries
        HashMap<Character, String> s_in_pattern = new HashMap<>();
        HashMap<String, Character> word_in_pattern = new HashMap<>();
        //split s into individual words
        String[] words = s.split(" ");

        //if the lengths of the pattern and words don't match, return false
        if (pattern.length() != words.length){
            return false;
        }
        
        for (int i = 0; i < pattern.length(); i++) {
            char charPattern = pattern.charAt(i);
            String word = words[i];
            // Check if charPattern is in s_in_pattern
            if (s_in_pattern.containsKey(charPattern)) {
                // Check for match, and if not return false
                if (!s_in_pattern.get(charPattern).equals(word)) {
                    return false;
                }
            } else {
                s_in_pattern.put(charPattern, word);
            }  

            // Check if word is in word_in_pattern
            if (word_in_pattern.containsKey(word)) {
                // Check for match, and if not return false
                if (word_in_pattern.get(word) != charPattern) {
                    return false;
                }
            } else {
                word_in_pattern.put(word, charPattern);
            }
        }
        return true;
    }
}
