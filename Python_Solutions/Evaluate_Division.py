"""
Leetocode Challenge: Evaluate Division

You are given an array of variable pairs equations and an array of 
real numbers values, where equations[i] = [Ai, Bi] and values[i] 
represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string 
that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents 
the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be 
determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the 
queries will not result in division by zero and that there is no 
contradiction.

Note: The variables that do not occur in the list of equations are 
undefined, so the answer cannot be determined for them.

8/31/24
Mark Robuck
"""
from collections import defaultdict

class Solution:
    """
    Find the value of all queries given previous equations and values.
    Args:
        equations(List[str]): list of pair of variables for a division
        values(List[float]): list of answers to related equations values
        queries(List[str]): list of pair of variables to be solved
    Returns:
        List[float]: list of solutions to queries
    """
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        #create a graph to store the relationships
        graph = defaultdict(dict)
        
        #populate the graph
        for (dividend, divisor), value in zip(equations, values):
            graph[dividend][divisor] = value
            graph[divisor][dividend] = 1 / value
        
        #DFS to find the result of a query
        def dfs(start, end, visited):
            if start not in graph or end not in graph:
                return -1.0
            if end in graph[start]:
                return graph[start][end]
            visited.add(start)
            for neighbor in graph[start]:
                if neighbor not in visited:
                    temp_result = dfs(neighbor, end, visited)
                    if temp_result != -1:
                        return graph[start][neighbor] * temp_result
            return -1.0
        
        #evaluate each query using DFS
        result = []
        for dividend, divisor in queries:
            if dividend == divisor:
                result.append(1.0 if dividend in graph else -1.0)
            else:
                result.append(dfs(dividend, divisor, set()))
        
        return result
