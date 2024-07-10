/*
* Leetcode Challenge: Two Sum II - Input Array Is Sorted
*
* Given a 1-indexed array of integers numbers that is 
* already sorted in ascending order, find two numbers 
* such that they add up to a specific target number. 
* Let these two numbers be numbers[index1] and numbers[index2] 
* where 1 <= index1 < index2 <= numbers.length.
*
* Return the indices of the two numbers, index1 and index2, added by one 
* as an integer array [index1, index2] of length 2.
* The tests are generated such that there is exactly one solution. 
* You may not use the same element twice.
* Your solution must use only constant extra space.
*
* 7/10/24
* Mark Robuck
*/
class Solution{
    /*
    * Find the index of two numbers in an array that add to a target sum.
    * @params numbers, list of integers
    * @params target, sum of the two target numbers to be found
    * @return an array of the index + 1 of each of the target numbers
    */
    public int[] twoSum(int[] numbers, int target) {
        for(int i  = 1;i<numbers.length;i++){
            for(int j = i; j<numbers.length;j++){
                if(numbers[j] + numbers[j-i] == target){
                    return new int[] {j-i+1, j+1};
                }
            }
        }
        return null;
    }
}
