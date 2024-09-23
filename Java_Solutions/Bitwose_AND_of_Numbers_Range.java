/*
* Leetcode Challenge: Bitwise AND of Numbers Range
*
* Given two integers left and right that represent the range 
* [left, right], return the bitwise AND of all numbers in this range, inclusive.
*
* 9/23/24
* Mark Robuck
*/

class Solution {
    /*
    * Calculate bitwise AND of a range of numbers.
    * @params left, left side of the number range
    * @params right, right side of the number range
    * @return bitwise AND of the range left to right
    */
    public int rangeBitwiseAnd(int left, int right) {
        //keep shifting left and right to the right until they are the same
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        //shift the result back to the left by the same amount
        return left << shift;
    }
}
