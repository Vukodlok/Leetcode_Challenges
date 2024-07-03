/*
* Leetcode Challenge: Candy
*
* There are n children standing in a line. Each child is assigned 
* a rating value given in the integer array ratings.
* You are giving candies to these children subjected to the following 
* requirements:
* Each child must have at least one candy.
* Children with a higher rating get more candies than their neighbors.
* Return the minimum number of candies you need to have 
* to distribute the candies to the children.
*
//this description was confusing to me given the examples.
//It means each child must have more candy than a child beside them
//with a lower rating, left and right.
* 
* 7/3/24
* Mark Robuck
*/
import java.util.Arrays;

class Solution{
    /*
    * Determine how much resource to assign each element in a list.
    * @params ratings, int list of ratings corresponding to each child
    * @return min number of candies needed as an integer
    */
    public int candy(int[] ratings) {
        //check for an empty lisy
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        //allocate one candy per child as an array
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++){
            //check the rating after each, 
            //if higher allocate one more than the previous child
            if (ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--){
            //check the rating before each, 
            //if lower allocate the max of either an extra candy or the current
            if (ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        //sum the array of allocated candies
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;    
    }
}
