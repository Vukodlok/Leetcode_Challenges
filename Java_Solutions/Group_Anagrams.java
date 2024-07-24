/*
* Leetcode Challenge: Group Anagrams
*
* Given an array of strings strs, group the anagrams together. 
* You can return the answer in any order.
* An Anagram is a word or phrase formed by rearranging the letters 
* of a different word or phrase, typically using all the original 
* letters exactly once.
*
* 7/24/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Determine which strings in a list are anagrams of one another.
    * @params strs, list of given strings
    * @return a list from strs organized into lists of strings that are anagrams of one another
        */
    public List<List<String>> groupAnagrams(String[] strs) {
        //create a dictionary to store anagram lists
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            //sort the string for processing
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            //append original string to list corresponding to this key
            if (!anagrams.containsKey(sortedStr)) {
                anagrams.put(sortedStr, new ArrayList<>());
            }
            anagrams.get(sortedStr).add(s);
        }
        return new ArrayList<>(anagrams.values());
    }
}
