/*
* Leetcode Challenge: Reverse Bits
*
* Reverse bits of a given 32 bits unsigned integer.
*
* Note:
* 
* Note that in some languages, such as Java, there is no unsigned integer type. In this case, both input and output will be given as a signed integer type. 
* They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
* In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above, 
* the input represents the signed integer -3 and the output represents the signed integer -1073741825.
*
* 5/7/24
* Mark Robuck
*/
public class Solution {
    /*
    * Reverse the order of the bits in a binary number
    * @params n, number to be reverse
    * @return, order of bits reversed from n
    * treat n as an unsigned value
    */
    public int reverseBits(int n) {
        int reverse = 0;
        //loop through the original 32 bit unsigned integer
        for (int i = 0; i < 32; i ++){
            //shift the bit right with >> and extract it with &
            int currentBit = (n >> i) & 1;
            //shift the bit left with << and set it with |
            reverse |= currentBit << (31 - i);
        }
        return reverse;
    }
}
