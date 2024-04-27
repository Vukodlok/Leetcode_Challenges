import java.math.BigInteger;

class Solution {
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
