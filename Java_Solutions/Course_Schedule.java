/*
* Leetcode Challenge: Course Schedule
*
* There are a total of numCourses courses you have to take, labeled 
* from 0 to numCourses - 1. You are given an array prerequisites 
* where prerequisites[i] = [ai, bi] indicates that you must take 
* course bi first if you want to take course ai.
*
* For example, the pair [0, 1], indicates that to take course 0 you 
* have to first take course 1.
*
* Return true if you can finish all courses. Otherwise, return false.
*
* 9/1/24
* Mark Robuck
*/

import java.util.*;

class Solution{
    /*
    * Check if all courses in a course list can be taken.
    * @params numCourses, number of courses in schedule as integer
    * @params prerequisites, integer list of course numbers in order to be taken
    * @return true if all courses can be taken, false otherwise
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build the adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            int dest = prereq[0], src = prereq[1];
            adjList.get(src).add(dest);
            indegree[dest]++;
        }

        //queue for courses with no prerequisites
        Queue<Integer> zeroIndegreeQueue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                zeroIndegreeQueue.offer(i);
            }
        }

        //process the queue
        int numCoursesTaken = 0;

        while (!zeroIndegreeQueue.isEmpty()) {
            int course = zeroIndegreeQueue.poll();
            numCoursesTaken++;

            for (int neighbor : adjList.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    zeroIndegreeQueue.offer(neighbor);
                }
            }
        }

        return numCoursesTaken == numCourses;
    }
}
