/*
* Leetcode Challenge: Minimum Number of Arrows to Burst Balloons
*
* There are some spherical balloons taped onto a flat wall that 
* represents the XY-plane. The balloons are represented as a 2D integer 
* array points where points[i] = [xstart, xend] denotes a balloon 
* whose horizontal diameter stretches between xstart and xend. 
* You do not know the exact y-coordinates of the balloons.
*
* Arrows can be shot up directly vertically (in the positive y-direction) 
* from different points along the x-axis. A balloon with xstart and xend 
* is burst by an arrow shot at x if xstart <= x <= xend. There is no limit 
* to the number of arrows that can be shot. A shot arrow keeps traveling 
* up infinitely, bursting any balloons in its path.
*
* Given the array points, return the minimum number of arrows that 
* must be shot to burst all balloons.
*
* 7/28/24
* Mark Robuck
*/
import java.util.Arrays;

class Solution{
    /*
    * count the number of non-overlapping intervals
    * @params points, list of balloon coordinates
    * @return minimum number of shots needed to burst all balloons
    */
    public int findMinArrowShots(int[][] points) {
        //empty list
        if (points == null || points.length == 0) {
            return 0;
        }

        //sort the list based on ending points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1;
        int currentEnd = points[0][1];
        //iterate through list and find number of non-overlapping intervals
        for (int[] point : points) {
            if (point[0] > currentEnd) {
                count++;
                currentEnd = point[1];
            }
        }
        return count;
    }
}
