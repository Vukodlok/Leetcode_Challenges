public class Solution {
    // you need treat n as an unsigned value
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
