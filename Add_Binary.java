/*
* Leetcode Challenge: Add Binary
*
* Given two binary strings a and b, return their sum as a binary string.
*
* 4/29/24
* Mark Robuck
*/
import java.math.BigInteger;

class Solution {
    /*
    *Sum two binary strings.
    * @parmas a, first binary string to add
    * @params b, second binary string to add
    * @return binary sum of a and b
    */
    public String addBinary(String a, String b) {
        //convert strings into binary numbers
        //in order to fix a runtime error for large values convert int to BigInteger
        BigInteger binaryA = new BigInteger(a, 2);
        BigInteger binaryB = new BigInteger(b, 2);
        //add binary numbers
        BigInteger binarySum = binaryA.add(binaryB);
        //convert binary back to string representation
        String sum = binarySum.toString(2);
        return sum;
    }
}
