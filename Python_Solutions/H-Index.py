"""
Leetcode Challenge: H-Index

Given an array of integers citations where citations[i] is the number of citations 
a researcher received for their ith paper, return the researcher's h-index.
According to the definition of h-index on Wikipedia: 
The h-index is defined as the maximum value of h such that 
the given researcher has published at least h papers 
that have each been cited at least h times.

6/28/24
Mark Robuck
"""
class Solution:
    """
    Given an array find the h-index, max value s.t. at least h values are h or greater.
    Args:
        citations(List[int]): list of citation amounts
    Returns:
        int: h-index
    """
    def hIndex(self, citations: List[int]) -> int:
        #sort the list for easier calculations later
        citations.sort()
        
        n = len(citations)
        for i in range(n):
            #starting from the end, 
            #do we have at least the quantity of the current value in the list
            h = n - i
            #check for h-index criteria
            if citations[i] >= h:
                return h
        return 0
