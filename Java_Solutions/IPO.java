/*
* Leetcode Challenge: IPO
*
* Suppose LeetCode will start its IPO soon. In order to sell a good price 
* of its shares to Venture Capital, LeetCode would like to work on some 
* projects to increase its capital before the IPO. Since it has 
* limited resources, it can only finish at most k distinct projects before 
* the IPO. Help LeetCode design the best way to maximize its total capital 
* after finishing at most k distinct projects.
*
* You are given n projects where the ith project has a pure profit 
* profits[i] and a minimum capital of capital[i] is needed to start it.
*
* Initially, you have w capital. When you finish a project, you will 
* obtain its pure profit and the profit will be added to your total capital.
*
* Pick a list of at most k distinct projects from given projects to maximize 
* your final capital, and return the final maximized capital.
*
* The answer is guaranteed to fit in a 32-bit signed integer.
*
* 9/21/24
* Mark Robuck
*/
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    /*
    * Maximize profit based on given projects, costs, and gains.
    * @params k, max projects that can be finished
    * @params w, starting capital
    * @params profits, list of profits from possible projects
    * @params capital, list of capital needed to start possible projects
    * @return final maximized profit as an integer
    */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        //min-heap for capital and max-heap for profits
        PriorityQueue<int[]> minCapitalHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>((a, b) -> b - a);
        
        //add all projects to min-heap, sorted by required capital
        for (int i = 0; i < profits.length; i++) {
            minCapitalHeap.offer(new int[] {capital[i], profits[i]});
        }
        
        for (int j = 0; j < k; j++) {
            //move projects to max-profit heap where we have enough capital
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek()[0] <= w) {
                maxProfitHeap.offer(minCapitalHeap.poll()[1]);
            }
            
            //if no project can be started, break out of the loop
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            
            //take the most profitable project
            w += maxProfitHeap.poll();
        }
        
        return w;
    }
}
