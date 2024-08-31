/*
* Leetocode Challenge: Evaluate Division
*
* You are given an array of variable pairs equations and an array of 
* real numbers values, where equations[i] = [Ai, Bi] and values[i] 
* represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string 
* that represents a single variable.
*
* You are also given some queries, where queries[j] = [Cj, Dj] represents 
* the jth query where you must find the answer for Cj / Dj = ?.
*
* Return the answers to all queries. If a single answer cannot be 
* determined, return -1.0.
*
* Note: The input is always valid. You may assume that evaluating the 
* queries will not result in division by zero and that there is no 
* contradiction.
*
* Note: The variables that do not occur in the list of equations are 
* undefined, so the answer cannot be determined for them.
*
* 8/31/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Find the value of all queries given previous equations and values.
    * @params equations, list of pair of variables for a division
    * @params values, list of answers to related equations values
    * @params queries, list of pair of variables to be solved
    * @return list of solutions to queries
    */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //create a graph to store the relationships
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        //populate the graph
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(dividend, new HashMap<>());
            graph.putIfAbsent(divisor, new HashMap<>());
            
            graph.get(dividend).put(divisor, value);
            graph.get(divisor).put(dividend, 1 / value);
        }
        
        //DFS to find the result of a query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                result[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = dfs(dividend, divisor, visited, graph);
            }
        }
        return result;
    }
    
    private double dfs(String start, String end, Set<String> visited, Map<String, Map<String, Double>> graph) {
        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        visited.add(start);
        for (String neighbor : graph.get(start).keySet()) {
            if (!visited.contains(neighbor)) {
                double tempResult = dfs(neighbor, end, visited, graph);
                if (tempResult != -1.0) {
                    return graph.get(start).get(neighbor) * tempResult;
                }
            }
        }
        return -1.0;
    }
}
