/*
* Leetcode Challenge: Substring with Concatenation of All Words
*
* You are given a string s and an array of strings words. 
* All the strings of words are of the same length.
* A concatenated string is a string that exactly contains 
* all the strings of any permutation of words concatenated.
* For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", 
* "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. 
* "acdbef" is not a concatenated string because it is not the 
* concatenation of any permutation of words.
* Return an array of the starting indices of all the concatenated substrings 
* in s. You can return the answer in any order.
*
* 7/15/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Find the indices of substrings within a string.
    * @params s, string to be checked
    * @params words, list of strings whose concatenation will be checked for within s
    * @return list of indices where the string concatenations start in s
    */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        //empty string or list
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            //create sliding window
            int left = i;
            int right = i;
            Map<String, Integer> currentCount = new HashMap<>();
            //use sliding window to check substrings
            while (right + wordLength <= s.length()) {
                String word = s.substring(right, right + wordLength);
                right += wordLength;
                //increment word count
                if (wordCount.containsKey(word)) {
                    currentCount.put(word, currentCount.getOrDefault(word, 0) + 1);

                    //check if substring has more occurrences than allowed
                    while (currentCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        currentCount.put(leftWord, currentCount.get(leftWord) - 1);
                        left += wordLength;
                    }
                    if (right - left == totalLength) {
                        result.add(left);
                    }
                } else {
                    //reset
                    currentCount.clear();
                    left = right;
                }
            }
        }
        return result;  
    }
}
