/*
* Leetcode Challenge: Ransom Note
* 
* Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
* 
* Each letter in magazine can only be used once in ransomNote.
* 
* 4/30/24
* Mark Robuck
*/
import java.util.ArrayList;

class Solution {
    /*
    * Determine if all characters in a string are contained within another string.
    * @params ransomNote, the string to be tested if all character are also within magazine
    * @params magazine, the string to be used to test if all characters from ransomNote are within it
    * @return true if all characters in ransomNote are within magazine, and false if not
    */
    public boolean canConstruct(String ransomNote, String magazine) {
        boolean containsAll = true;
        //create an array of letters for each string
        ArrayList<Character> ransomLetters = new ArrayList<Character>();
        ArrayList<Character> magazineLetters = new ArrayList<Character>();
        for (char c : ransomNote.toCharArray()) {
            ransomLetters.add(c);
        }
        for (char c : magazine.toCharArray()) {
            magazineLetters.add(c);
        }
        //loop through ransom array
        for (char c: ransomLetters) {
            //check to see if each letter in ransom is in magazine
            if (magazineLetters.contains(c)) {
                //if yes remove it from magazine
                    magazineLetters.remove(Character.valueOf(c));
            }
            //else if letter not in magazine return false
            else{
                return false;
            }
        }
        //if reach the end of the loop return true
        return true;
    }
}
