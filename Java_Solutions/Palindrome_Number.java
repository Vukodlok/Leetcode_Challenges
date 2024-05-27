/*
* Leetcode Challenge: Palindrome Number
*
* Given an integer x, return true if x is a palindrome, and false otherwise.
*
* 4/30/24
* Mark Robuck
*/
import java.util.ArrayList;

class Solution {
    /*
    * Check if a number is a palindrome.
    * @params x, integer number to be checked
    * @return true if x is a palindrome, false if not a palindrome
    */
    public boolean isPalindrome(int x) {
        boolean isPalindrome = true;
        //ignore negatives since they are not palindromes by the challenge description
        if (x < 0) {
            isPalindrome = false;
            return isPalindrome;
        }
        //create an array filled with the digits of the number
        int num = x;
        ArrayList<Integer> digits = new ArrayList<>();
        while (num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
        //create a left and right side tracking variable
        int left = 0;
        int right = digits.size() - 1;
        //loop through given number to the center
        for (int i = 0; i < digits.size()/2; i++) {
            //if numbers are equal move left and right one spot and continue
            if (digits.get(left) == digits.get(right)) {
                left ++;
                right--;
            }
            else {
                //if numbers are not equal break the loop and end
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
