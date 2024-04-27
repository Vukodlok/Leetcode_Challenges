class Solution {
    public String addBinary(String a, String b) {
        //convert strings into binary numbers
        int binaryA = Integer.parseInt(a, 2);
        int binaryB = Integer.parseInt(b, 2);
        //add binary numbers
        int binarySum = binaryA + binaryB;
        //convert binary back to string representation
        String sum = Integer.toBinaryString(binarySum);
        return sum;
    }
}
