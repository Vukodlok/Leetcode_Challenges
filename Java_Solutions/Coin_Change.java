/*
* Leetcode Challenge: Coin Change
*
* You are given an integer array coins representing coins of different 
* denominations and an integer amount representing a total amount of money.
*
* Return the fewest number of coins that you need to make up that amount. 
* If that amount of money cannot be made up by any combination of 
* the coins, return -1.
*
* You may assume that you have an infinite number of each kind of coin.
*
* 9/25/24
* Mark Robuck
*/
import java.util.Arrays;

class Solution {
    /*
    * Determine the fewest number of coins to make change.
    * @params coins, list of coin denominations
    * @params amount, integer representing amount of money
    * @return fewest number of coins needed, or -1 if not possible
    */
    public int coinChange(int[] coins, int amount) {
        //dp[i] represents the minimum coins required to make amount i
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        //base case: to make 0 amount, 0 coins are needed
        dp[0] = 0;
        
        //iterate over each amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        //if dp[amount] is still infinity, not possible to make amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
