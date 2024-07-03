"""
Leetcode Challenge: Candy

There are n children standing in a line. Each child is assigned 
a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following 
requirements:
Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have 
to distribute the candies to the children.

#this description was confusing to me given the examples.
#It means each child must have more candy than a child beside them
#with a lower rating, left and right.

7/3/24
Mark Robuck
"""
class Solution:
    """
    Determine how much resource to assign each element in a list.
    Args:
        ratings(List[int]): rating corresponding to each child
    Returns:
        int: min number of candies needed
    """
    def candy(self, ratings: List[int]) -> int:
        #check for an empty lisy
        if not ratings:
            return 0
        #allocate one candy per child as an array
        candies = [1] * len(ratings)

        for i in range(1, len(ratings)):
            #check the rating after each, 
            #if higher allocate one more than the previous child
            if ratings[i] > ratings[i-1]:
                candies[i] = candies[i-1] + 1
        for i in range(len(ratings)-2, -1, -1):
            #check the rating before each, 
            #if lower allocate the max of either an extra candy or the current
            if ratings[i] > ratings[i+1]:
                candies[i] = max(candies[i], candies[i+1] + 1)
        #sum the array of allocated candies
        return sum(candies)
