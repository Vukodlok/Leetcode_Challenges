/*
* Leetcode Challenge: Search a 2D Matrix
*
* You are given an m x n integer matrix matrix with the following 
* two properties:
* Each row is sorted in non-decreasing order.
* The first integer of each row is greater than the last integer 
* of the previous row.
*
* Given an integer target, return true if target is in matrix or 
* false otherwise.
* You must write a solution in O(log(m * n)) time complexity.
*
* 9/17/24
* Mark Robuck
*/

class Solution {
    /*
    * Determine if an integer is in a matrix.
    * @params matrix, 2D matrix of integers
    * @params target, integer to search matrix for
    * @return true if target exists in matrix, false otherwise
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        //empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        //binary search
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}
