/*
* Leetcode Challenge: Spiral Matrix
*
* Given an m x n matrix, return all elements of the matrix in 
* spiral clockwise order.
*
* 7/19/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution{
    /*
    * Return a list of elements from a matrix in a specific order
    * @params matrix, original 2D array (matrix)
    * @return list in spiral clockwise order
    */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        //empty matrix or single row
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        //create pointers
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        //repeat until boundaries overlap
        while (top <= bottom && left <= right) {
            //traverse left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            //move down one row
            top++;
            //traverse top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            //move left one column
            right--;

            if (top <= bottom){
            //traverse right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                //move up one row
                bottom--;
            }

            if (left <= right){
                //traverse bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                //move right one column
                left++;
            }
        }

        return result;
    }
}
