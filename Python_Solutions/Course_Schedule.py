"""
Leetcode Challenge: Course Schedule

There are a total of numCourses courses you have to take, labeled 
from 0 to numCourses - 1. You are given an array prerequisites 
where prerequisites[i] = [ai, bi] indicates that you must take 
course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you 
have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

9/1/24
Mark Robuck
"""

class Solution:
    """
    Check if all courses in a course list can be taken.
    Args:
        numCourses(int): number of courses in schedule
        prerequisites(List[int]): integer list of course numbers in order to be taken
    Returns: 
        bool: true if all courses can be taken, false otherwise
    """
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #build the adjacency list
        adj_list = defaultdict(list)
        indegree = [0] * numCourses

        for dest, src in prerequisites:
            adj_list[src].append(dest)
            indegree[dest] += 1

        #queue for courses with no prerequisites
        zero_indegree_queue = deque([i for i in range(numCourses) if indegree[i] == 0])

        #process the queue
        num_courses_taken = 0

        while zero_indegree_queue:
            course = zero_indegree_queue.popleft()
            num_courses_taken += 1

            for neighbor in adj_list[course]:
                indegree[neighbor] -= 1
                if indegree[neighbor] == 0:
                    zero_indegree_queue.append(neighbor)

        return num_courses_taken == numCourses
        
