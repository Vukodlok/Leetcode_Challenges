/*
* Leetcode Challenge: Reverse Words in a String
*
* Given an input string s, reverse the order of the words.
* A word is defined as a sequence of non-space characters. 
* The words in s will be separated by at least one space.
* Return a string of the words in reverse order concatenated by a single space.
* Note that s may contain leading or trailing spaces or 
* multiple spaces between two words. The returned string should 
* only have a single space separating the words. 
* Do not include any extra spaces.
*
* 7/6/24
* Mark Robuck
*/
class Solution{
    /*
    * Reverse the words in a given string.
    * @params s, original string of words separated by space
    * @return string with words in reverse order from s
    */
    public String reverseWords(String s) {
        String reverse = "";
        //split the string into words in an array
        String[] words = s.split("\\s+");
        //traverse the array backwards adding words to a new empty string
        for (int i = words.length - 1; i >= 0; i--){
            reverse += words[i] + " ";
        }
        //remove leading and trailing space
        return reverse.trim();
    }
}
