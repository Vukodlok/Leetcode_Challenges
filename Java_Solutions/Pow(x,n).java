/*
* Leetcode Challenge: Pow(x,n)
*
* Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
*
* 5/27/24
* Mark Robuck
*/
class Solution {
    /*
    * Calculates an exponent.
    * 
    * @params x, base as a double
    * @params n, power/exponent as an int
    * @returns, result of x to the n power as a double
    */
    public double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0) {
            return 1;
        }  
        // If n is negative, invert x and make n positive
        if (n < 0){
            x = 1 / x;
            // Handle potential overflow
            if (n == Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                return x * myPow(x, n);
            }
            n = -n;
        }
        // Recursively reduce n by half in order to create smaller subproblems
        double half = myPow(x, n / 2);
        // If n is even
        if (n % 2 == 0) {
            return half * half;
        }
        // If n is odd
        else{
            return half * half * x;
        }
    }
}
