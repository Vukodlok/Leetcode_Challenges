/*
* Leetcode Challenge: Length of Last Word
* 
* Given a string s consisting of words and spaces, return the length of the last word in the string.
* 
* 4/27/24
* Mark Robuck
*/
class Solution {
        /*
        * return the length of the last word in a string
        * @params s, given string
        * @return length of the last word in the string as an integer
        */
    public int lengthOfLastWord(String s) {
        //split the string into 'words' and store in an array
        String words[] = s.split("\\s+");
        //grab the last index in the array
        String lastWord = words[words.length-1];
        //find the length and print the results
        return lastWord.length();
    }
}
