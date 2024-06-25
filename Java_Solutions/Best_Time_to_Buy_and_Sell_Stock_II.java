/*
* Leetcode Challenge: Best Time to Buy and Sell Stock II
*
* You are given an integer array prices where prices[i] is 
* the price of a given stock on the ith day.
* On each day, you may decide to buy and/or sell the stock. 
* You can only hold at most one share of the stock at any time. 
* However, you can buy it then immediately sell it on the same day.
* Find and return the maximum profit you can achieve.
*
* 6/25/24
* Mark Robuck
*/
class Solution{
    /*
    * Find the max profit by buying/selling an individual stock 
    * given a list of daily prices.
    * @params prices, list of daily prices of a given stock as an integer
    * @return max profit from buying/selling a single share as an integer
    */
    public int maxProfit(int[] prices) {
        int max = 0;
        //iterate through daily prices
        for (int i = 1; i < prices.length; i++){
            //if today is higher than yesterday "buy/sell" (add difference to max)
            if (prices[i] > prices[i-1]){
                max += prices[i] - prices[i-1];
            }
        }
        return max;        
    }
}
/*
* In my Python post-solution research I found removing the diff=prices[i] - proces[i-1]
* and using the expression directly with the max += assignment improved efficiency.  I 
* modified my Java code to reflect this.
*/
