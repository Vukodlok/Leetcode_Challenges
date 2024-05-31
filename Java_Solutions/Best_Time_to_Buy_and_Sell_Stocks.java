/*
* Leetcode Challenge: Best Time to Buy and Sell Stock
*
* You are given an array prices where prices[i] is the price of a 
* given stock on the ith day.
* You want to maximize your profit by choosing a single day to buy one stock 
* and choosing a different day in the future to sell that stock.
* Return the maximum profit you can achieve from this transaction. 
* If you cannot achieve any profit, return 0.
*
* 5/31/24
* Mark Robuck
*/
class Solution {
    /*
    * find the max profit from a list of ints 
    * where we buy at a low index and sell high at a later index
    * @params prices, list of stock prices by day as integers
    * @return, max profit made by buying low and selling at a later high as an int
    */
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        //iterate through prices for every index finding the difference
        for (int i : prices){
            //track the min
            if (i < min){
                min = i;
            }
            //find the difference
            int diff = i - min;
            //track the max
            if (diff > max){
                max = diff;
            }
        }
        return max;
    }
}
