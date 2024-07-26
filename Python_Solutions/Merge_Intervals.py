"""
Leetcode Challenge: Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], 
merge all overlapping intervals, and return an array of 
the non-overlapping intervals that cover all the intervals in the input.

7/26/24
Mark Robuck
"""

class Solution:
    """
    Merge multiple overlapping intervals ranges.
    Args:
        intervals(List[List[int]]): original list of intervals
    Returns:
        List[List[int]]: updated merged list of intervals
    """
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        merged_intervals = []

        #empty list
        if not intervals:
            return merged_intervals

        # Sort intervals based on the starting point of each interval
        intervals.sort(key=lambda x: x[0])

        #create a current interval to track comparisons
        current_interval = intervals[0]
        merged_intervals.append(current_interval)

        #check if next interval overlaps current interval
        for next_interval in intervals:
            current_end = current_interval[1]
            next_start = next_interval[0]
            next_end = next_interval[1]

            if current_end >= next_start:
                # If they overlap, merge the intervals by updating the end
                current_interval[1] = max(current_end, next_end)
            else:
                # If they don't overlap, add the next interval to the list
                current_interval = next_interval
                merged_intervals.append(current_interval)

        return merged_intervals
