/*
* Leetcode Challenge: Factorial Trailing Zeroes
*
* Given an integer n, return the number of trailing zeroes in n!.
* Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
*
* 9/23/24
* Mark Robuck
*/

class Solution {
    /*
    * Return the number of trailing zeroes in a factorial calculation.
    * @params n, number to take the factorial of
    * @return number of trailing zeroes in n!
    */
    public int trailingZeroes(int n) {
        int count = 0;
        //count how many times 5 is a factor in the numbers from 1 to n
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}

/*
* A trailing zero is created by multiplying 10, which is the result 
* of multiplying 2 and 5. In any factorial, there are always more 
* factors of 2 than 5, so the number of trailing zeroes is determined 
* by how many times 5 is a factor in the numbers from 1 to n.
*/
