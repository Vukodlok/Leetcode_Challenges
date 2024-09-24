"""
Leetcode Challenge: Max Points on a Line

Given an array of points where points[i] = [xi, yi] represents a 
point on the X-Y plane, return the maximum number of points that 
lie on the same straight line.

9/24/24
Mark Robuck
"""
from collections import defaultdict
from math import gcd

class Solution:
    """
    Find max number of points on a line.
    Args:
        points(List[int]): list of x, y coordinates
    Returns:
        int: max number of points in the list on a straight line
    """
    def maxPoints(self, points: List[List[int]]) -> int:
        #one or no point, return the number of points
        if len(points) <= 2:
            return len(points)

        #get the slope of the line between points p1 and p2
        def getSlope(p1, p2):
            dx = p2[0] - p1[0]
            dy = p2[1] - p1[1]
            #vertical line
            if dx == 0:
                return (float('inf'), 0)
            #horizontal line
            if dy == 0:
                return (0, float('inf'))
            d = gcd(dx, dy)
            slope = (dy // d, dx // d) if dx > 0 else (-dy // d, -dx // d)
            return slope

        max_points = 1
        #iterate over each point and calculate how many points are collinear
        for i in range(len(points)):
            slopes = defaultdict(int)
            duplicates = 1
            local_max = 0
            for j in range(i + 1, len(points)):
                if points[i] == points[j]:
                    duplicates += 1
                    continue
                slope = getSlope(points[i], points[j])
                slopes[slope] += 1
                local_max = max(local_max, slopes[slope])
            max_points = max(max_points, local_max + duplicates)
        
        return max_points
        
