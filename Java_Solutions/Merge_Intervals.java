/*
* Leetcode Challenge: Merge Intervals
*
* Given an array of intervals where intervals[i] = [starti, endi], 
* merge all overlapping intervals, and return an array of 
* the non-overlapping intervals that cover all the intervals in the input.
*
* 7/26/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    /*
    * Merge multiple overlapping intervals ranges.
    * @params intervals, original list of intervals
    * @return updated merged list of intervals
    */
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();

        //empty list
        if (intervals.length == 0) {
            return new int[0][];
        }

        //sort intervals based on the starting point of each interval
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        //create a current interval to track comparisons
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        //check if next interval overlaps current interval
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                //if they overlap, merge the intervals by updating the end
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                //if they don't overlap, add the next interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
