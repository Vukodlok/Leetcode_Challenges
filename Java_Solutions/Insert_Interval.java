/*
* Leetcode Challenge: Insert Interval
*
* You are given an array of non-overlapping intervals "intervals" 
* where intervals[i] = [starti, endi] represent the start and the end 
* of the ith interval and intervals is sorted in ascending order by starti. 
* You are also given an interval newInterval = [start, end] that represents 
* the start and end of another interval.
*
* Insert newInterval into intervals such that intervals is still sorted 
* in ascending order by starti and intervals still does not have any 
* overlapping intervals (merge overlapping intervals if necessary).
* Return intervals after the insertion.
*
* Note that you don't need to modify intervals in-place. 
* You can make a new array and return it.
*
* 7/27/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.List;

class Solution{
    /*
    * Insert a new interval into a list of intervals.
    * @params intervals, original list of intervals
    * @params newInterval, new interval to insert into intervals
    * @eeturn merged sorted list of intervals and newInterval
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        //iterate through the intervals
        for (int i = 0; i < intervals.length; i++) {
            //if current interval is before new interval add to result
            if (intervals[i][1] < newInterval[0]) {
                result.add(intervals[i]);
            }
            //if current interval is completely after new interval
            else if (intervals[i][0] > newInterval[1]) {
                result.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    result.add(intervals[j]);
                }
                return result.toArray(new int[result.size()][]);
            }
            //merge overlapping intervals
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}
