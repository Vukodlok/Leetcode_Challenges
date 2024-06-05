/*
* Leetcode Challenge: Isomorphic Strings
*
* Given two strings s and t, determine if they are isomorphic.
* Two strings s and t are isomorphic if the characters in s can be replaced to get t.
* All occurrences of a character must be replaced with another character while preserving 
* the order of characters. No two characters may map to the same character, but a 
* character may map to itself.
*
* 6/5/24
* Mark Robuck
*/
import java.util.HashMap;

class Solution {
    /*
    * Check if all occurrences of specific letters are replaced with another character, 
    * maintaining order.
    * @params s, original string
    * @params t, final string with replaced characters
    * @ return true if the process can be completed (are isomorphic), false otherwise
    */
    public boolean isIsomorphic(String s, String t) {
        //check for different lengths
        if (s.length() != s.length()) {
            return false;
        }
        //create HashMap dictionaries for both directional checks
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        //loop through strings in parallel
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            // Check the mapping from s to t
            if (sToT.containsKey(charS)) {
                if (sToT.get(charS) != charT) {
                    return false;
                }
            } else {
                sToT.put(charS, charT);
            }

            // Check the mapping from t to s
            if (tToS.containsKey(charT)) {
                if (tToS.get(charT) != charS) {
                    return false;
                }
            } else {
                tToS.put(charT, charS);
            }
        }
        //all key values match        
        return true;
    }
}

/* Below is a more efficient and easier to follow for me personally solution.
class Solution {
    public boolean isIsomorphic(String s, String t) {
         HashMap<Character,Character> map = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for (int i = 0; i <s.length() ; i++) {
            char key=s.charAt(i); //b
            char value=t.charAt(i); //y
            if(map.containsKey(key)){
                if(map.get(key)==value)
                    continue;
                return false;
            }
            else{
                if(map.containsValue(value)){
                    return false;
                }
                else {
                    map.put(key, value);
                }
            }
        }
        return true;
    }
}
*/
