"""
Leetcode Challenge: Course Schedule II

There are a total of numCourses courses you have to take, 
labeled from 0 to numCourses - 1. You are given an array prerequisites 
where prerequisites[i] = [ai, bi] indicates that you must take course 
bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have 
to first take course 1.

Return the ordering of courses you should take to finish all courses. 
If there are many valid answers, return any of them. If it is impossible 
to finish all courses, return an empty array.

9/2/24
Mark Robuck
"""
from collections import defaultdict, deque

class Solution:
    """
    Given a course list and a prerequisite list determine a course order.
    Args:
        numCourses(int): number of courses to take
        prerequisites(List[int]): array of course numbers that must be taken before other courses
    Return:
        List: order of courses to take
    """
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        #build the graph and the in-degree array
        graph = defaultdict(list)
        in_degree = [0] * numCourses
        
        for course, prereq in prerequisites:
            graph[prereq].append(course)
            in_degree[course] += 1
            
        #initialize the queue with courses having no prerequisites
        queue = deque([i for i in range(numCourses) if in_degree[i] == 0])
        order = []
        
        while queue:
            current_course = queue.popleft()
            order.append(current_course)
            
            for neighbor in graph[current_course]:
                in_degree[neighbor] -= 1
                if in_degree[neighbor] == 0:
                    queue.append(neighbor)
        
        #check if the order contains all the courses
        if len(order) == numCourses:
            return order
        else:
            return []
