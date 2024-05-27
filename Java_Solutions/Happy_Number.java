/*
* Leetcode Challenge: Happy Number
* 
* Write an algorithm to determine if a number n is happy.
* 
* A happy number is a number defined by the following process:
* 
* Starting with any positive integer, replace the number by the sum of the squares of its digits.
* Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
* Those numbers for which this process ends in 1 are happy.
* Return true if n is a happy number, and false if not.
* 
* 5/20/24
* Mark Robuck
*/
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> digits = new ArrayList<>();
    public static int result;
    /*
    * Repeat testing of an integer until the result is either 1 or an infinite loop.
    * @params n, integer to be tested
    * @return true if n is a happy number by the given definition, false if not a happy number
    */
    public boolean isHappy(int n) {
        //used to store current iteration of happy number calculation
        result = n;
        //used to store a set of already seen numbers from result
        HashSet<Integer> repeats = new HashSet<>();
        //loop until result is 1 or pattern repeats
        while (result != 1 && !(repeats.contains(result))){
            //add result to the reapeats set
            repeats.add(result);
            //split the number into digits
            splitDigits(result);
            //clear result for storing new int after calculation
            result = 0;
            //perform squaring and sum
            calcHappy();
        }
        return result == 1;
    }
    /*
    * Split an integer into individual digits
    * @params num, integer to be split
    */
    public void splitDigits(int num) {
        digits.clear();
        //split num into individual digits and add to the set digits
        while (num > 0) {
            int digit = num % 10;
            digits.add(digit);
            num /= 10;
        }
    }
    /*
    * Calculate the sum of the squares of all digits in a list
    */
    public void calcHappy() {
        //perform squaring and sum
        for (int num : digits){
            result += Math.pow(num, 2);
        }
    }
}
