/*
* Leetcode Challenge: Best Time to Buy and Sell Stock III
*
* You are given an array prices where prices[i] is the price of a 
* given stock on the ith day. Find the maximum profit you can achieve. 
* You may complete at most two transactions.
*
* Note: You may not engage in multiple transactions simultaneously 
* (i.e., you must sell the stock before you buy again).
*
* 9/28/24
* Mark Robuck
*/

class Solution {
    /*
    * Find max profit with at most two transactions.
    * @params prices, list of the price of a stock on the ith day
    * @return max profit that can be achieved with at most two transactions
    */
    public int maxProfit(int[] prices) {
        //empty list
        if (prices.length == 0) {
            return 0;
        }
        
        //initialize variables for the two transactions
        int buy1 = Integer.MAX_VALUE;
        int buy2 = Integer.MAX_VALUE;
        int profit1 = 0;
        int profit2 = 0;
        
        for (int price : prices) {
            //first transaction: minimize buy1 and maximize profit1
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);
            
            //second transaction: minimize buy2 with profit1 as an offset, and maximize profit2
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }
        
        return profit2;
    }
}
