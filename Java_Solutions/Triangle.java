/*
* Leetcode Challenge: Triangle
*
* Given a triangle array, return the minimum path sum from top to bottom.
*
* For each step, you may move to an adjacent number of the row below. 
* More formally, if you are on index i on the current row, you may move 
* to either index i or index i + 1 on the next row.
*
* 9/26/24
* Mark Robuck
*/
import java.util.List;

class Solution {
    /*
    * Find the minimum path sum of a triangle array.
    * @params triangle, given triangle array
    * @return minimum path sum from top to bottom of triangle
    */
    public int minimumTotal(List<List<Integer>> triangle) {
        //start from the second-last row and move upwards
        for (int row = triangle.size() - 2; row >= 0; row--) {
            for (int col = 0; col < triangle.get(row).size(); col++) {
                //take current element and add the min of two adjacent numbers from the row below
                int sum = triangle.get(row).get(col) + Math.min(triangle.get(row + 1).get(col), triangle.get(row + 1).get(col + 1));
                triangle.get(row).set(col, sum);
            }
        }
        
        return triangle.get(0).get(0);
    }
}
