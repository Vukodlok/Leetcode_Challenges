/*
* Leetcode Challenge: Rotate Image
*
* You are given an n x n 2D matrix representing an image, 
* rotate the image by 90 degrees (clockwise).
* You have to rotate the image in-place, which means 
* you have to modify the input 2D matrix directly. DO NOT allocate 
* another 2D matrix and do the rotation.
*
* 7/21/24
* Mark Robuck
*/
class Solution{
    /*
    * Rotate the elements of a matrix 90 degrees clockwise.
    * @params matrix, original matrix representing an image
    */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }
}
