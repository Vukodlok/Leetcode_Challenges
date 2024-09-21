"""
Leetcode Challenge: IPO

Suppose LeetCode will start its IPO soon. In order to sell a good price 
of its shares to Venture Capital, LeetCode would like to work on some 
projects to increase its capital before the IPO. Since it has 
limited resources, it can only finish at most k distinct projects before 
the IPO. Help LeetCode design the best way to maximize its total capital 
after finishing at most k distinct projects.

You are given n projects where the ith project has a pure profit 
profits[i] and a minimum capital of capital[i] is needed to start it.

Initially, you have w capital. When you finish a project, you will 
obtain its pure profit and the profit will be added to your total capital.

Pick a list of at most k distinct projects from given projects to maximize 
your final capital, and return the final maximized capital.

The answer is guaranteed to fit in a 32-bit signed integer.

9/21/24
Mark Robuck
"""
import heapq

class Solution:
    """
    Maximize profit based on given projects, costs, and gains.
    Args:
        k(int): max projects that can be finished
        w(int): starting capital
        profits(List[int]): list of profits from possible projects
        capital(List[int]): list of capital needed to start possible projects
    Returns:
        int: final maximized profit
    """
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        #min-heap for capital and max-heap for profits
        min_capital_heap = []
        max_profit_heap = []
        
        #combine capital and profits into a list of tuples and sort by capital
        projects = [(capital[i], profits[i]) for i in range(len(profits))]
        projects.sort()
        
        i = 0
        
        for _ in range(k):
            #push all projects that can be started with current capital into the max-profit heap
            while i < len(projects) and projects[i][0] <= w:
                #use negative profit because heapq is a min-heap by default, and we want max profit
                heapq.heappush(max_profit_heap, -projects[i][1])
                i += 1
            
            #if there are no projects we can afford, stop
            if not max_profit_heap:
                break
            
            #take the most profitable project
            w -= heapq.heappop(max_profit_heap)
        
        return w
        
