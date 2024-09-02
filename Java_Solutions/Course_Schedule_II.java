/*
* Leetcode Challenge: Course Schedule II
*
* There are a total of numCourses courses you have to take, 
* labeled from 0 to numCourses - 1. You are given an array prerequisites 
* where prerequisites[i] = [ai, bi] indicates that you must take course 
* bi first if you want to take course ai.
*
* For example, the pair [0, 1], indicates that to take course 0 you have 
* to first take course 1.
*
* Return the ordering of courses you should take to finish all courses. 
* If there are many valid answers, return any of them. If it is impossible 
* to finish all courses, return an empty array.
*
* 9/2/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Given a course list and a prerequisite list determine a course order.
    * @numCourses, number of courses to take as an integer
    * @prerequisites, list of course numbers that must be taken before other courses represented as integers
    * Return order of courses to take as a list of integers
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //build the graph and the in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }
            
        //initialize the queue with courses having no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int[] order = new int[numCourses];
        int index = 0;
        
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            order[index++] = currentCourse;
            
            for (int neighbor : graph.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        //check if the order contains all the courses
        if (index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }
}
