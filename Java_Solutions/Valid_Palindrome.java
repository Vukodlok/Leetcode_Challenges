/*
* Leetcode Challenge: Valid Palindrome
* 
* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
* it reads the same forward and backward. Alphanumeric characters include letters and numbers.
* 
* Given a string s, return true if it is a palindrome, or false otherwise.
* 
* 5/17/24
* Mark Robuck
*/
class Solution {
    /*
    * Determine if a string is a palindrome.
    *
    * @params s, string to be tested
    * @return boolean as true if the string is a palindrome, or false if the string is not a palindrome
    */
    public boolean isPalindrome(String s) {
        //create new empty string
        String newS = "";
        //remove spaces and non-alphanumeric characters, and convert to lowercase
        newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //create left and right side pointers
        int left = 0;
        int right = newS.length()-1;
        //create true boolean flag to track palindrome status
        boolean isPalindrome = true;
        //loop to the middle
        while (left <= right){
            //check if left and right are different
            if (newS.charAt(left) != newS.charAt(right)){
                //if different end and set flag to false
                isPalindrome = false;
                break;
            }
            //otherwise continue to next pair of characters
            right--;
            left++;
        }
        //return boolean flag
        return isPalindrome;
    }
}
