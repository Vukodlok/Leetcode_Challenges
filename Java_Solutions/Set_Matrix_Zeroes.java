/*
* Leetcode Challenge: Set Matrix Zeroes
*
* Given an m x n integer matrix matrix, if an element is 0, 
* set its entire row and column to 0's.
* You must do it in place.
*
* 7/22/24
* Mark Robuck
*/
class Solution{
    /*
    * If an element in a matrix is zero, set entire row/column to zero.
    * @params matrix, original matrix to check
    */
    public void setZeroes(int[][] matrix) {
        //create lists of zero elements
        Set<Integer> rowsToZero = new HashSet<>();
        Set<Integer> colsToZero = new HashSet<>();
        int rows = matrix.length;
        int cols = matrix[0].length;

        //loop through matrix searching for zeroes to add to sets
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                if (matrix[row][col] == 0){
                    rowsToZero.add(row);
                    colsToZero.add(col);
                }
            }
        }

        //set rows to zero if in zeros_in_rows set
        for (int row : rowsToZero){
            for (int col = 0; col < cols; col++){
                matrix[row][col] = 0;
            }
        }

        //set columns to zero if in zeros_in_cols set
        for (int col : colsToZero){
            for (int row = 0; row < rows; row++){
                matrix[row][col] = 0   ;
            }
        }     
    }
}
