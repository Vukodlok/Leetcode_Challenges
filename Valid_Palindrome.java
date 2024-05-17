class Solution {
    public boolean isPalindrome(String s) {
        //create new empty string
        String newS = "";
        //remove spaces and non-alphanumeric characters, and convert to lowercase
        newS = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        //create left and right side pointers
        int left = 0;
        int right = newS.length()-1;
        //create true boolean flag to track palindrome status
        boolean isPalindrome = true;
        //loop to the middle
        while (left <= right){
            //check if left and right are different
            if (newS.charAt(left) != newS.charAt(right)){
                //if different end and set flag to false
                isPalindrome = false;
                break;
            }
            //otherwise continue to next pair of characters
            right--;
            left++;
        }
        //return boolean flag
        return isPalindrome;
    }
}
