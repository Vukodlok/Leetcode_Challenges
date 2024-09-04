"""
Leetcode Challenge: Minimum Genetic Mutation

A gene string can be represented by an 8-character long string, 
with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string 
startGene to a gene string endGene where one mutation is defined 
as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene 
mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, 
return the minimum number of mutations needed to mutate from startGene 
to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, 
so it might not be included in the bank.

9/4/24
Mark Robuck
"""
from collections import deque

class Solution:
    """
    Find the min number of mutations to result in the ending gene.
    Args:
        startGene(str): 8 character string representing starting gene
        endGene(str): 8 character string representing ending gene
        bank(List[str]): list of all possible valid mutations
    Returns:
        int: min number of mutations needed to result in ending gene
    """
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        #endGene not in the bank of valid mutations
        if endGene not in bank:
            return -1

        bankSet = set(bank)
        queue = deque([(startGene, 0)])
        visited = set([startGene])
        gene_chars = ['A', 'C', 'G', 'T']
        
        while queue:
            current_gene, mutations = queue.popleft()
            
            if current_gene == endGene:
                return mutations
            
            for i in range(len(current_gene)):
                for char in gene_chars:
                    mutated_gene = current_gene[:i] + char + current_gene[i+1:]
                    
                    #check for valid mutation
                    if mutated_gene in bankSet and mutated_gene not in visited:
                        visited.add(mutated_gene)
                        queue.append((mutated_gene, mutations + 1))
                        
        return -1
