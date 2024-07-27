"""
Leetcode Challenge: Insert interval

You are given an array of non-overlapping intervals "intervals" 
where intervals[i] = [starti, endi] represent the start and the end 
of the ith interval and intervals is sorted in ascending order by starti. 
You are also given an interval newInterval = [start, end] that represents 
the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted 
in ascending order by starti and intervals still does not have any 
overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.

Note that you don't need to modify intervals in-place. 
You can make a new array and return it.

7/27/24
Mark Robuck
"""
class Solution:
    """
    Insert a new interval into a list of intervals.
    Args:
        intervals(List[List[int]]): original list of intervals
        newInterval(List[in]): new interval to insert into intervals
    Returns:
        List[List[int]]: merged sorted list of intervals and newInterval
    """
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []

        #iterate through the intervals
        for i in range(len(intervals)):
            #if current interval is before new interval add to result
            if intervals[i][1] < newInterval[0]:
                result.append(intervals[i])
            #if current interval is completely after new interval
            elif intervals[i][0] > newInterval[1]:
                result.append(newInterval)
                return result + intervals[i:]
            #merge overlapping intervals
            else:
                newInterval[0] = min(newInterval[0], intervals[i][0])
                newInterval[1] = max(newInterval[1], intervals[i][1])

        result.append(newInterval)
        return result
