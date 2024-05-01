import java.util.ArrayList;

class Solution {
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
