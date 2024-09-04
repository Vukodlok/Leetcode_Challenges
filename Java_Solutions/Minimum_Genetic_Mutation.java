/*
* Leetcode Challenge: Minimum Genetic Mutation
*
* A gene string can be represented by an 8-character long string, 
* with choices from 'A', 'C', 'G', and 'T'.
*
* Suppose we need to investigate a mutation from a gene string 
* startGene to a gene string endGene where one mutation is defined 
* as one single character changed in the gene string.
*
* For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
* There is also a gene bank bank that records all the valid gene 
* mutations. A gene must be in bank to make it a valid gene string.
*
*Given the two gene strings startGene and endGene and the gene bank bank, 
* return the minimum number of mutations needed to mutate from startGene 
* to endGene. If there is no such a mutation, return -1.
*
* Note that the starting point is assumed to be valid, 
* so it might not be included in the bank.
*
* 9/4/24
* Mark Robuck
*/
import java.util.*;

class Solution{
    /*
    * Find the min number of mutations to result in the ending gene.
    * @params startGene, 8 character string representing starting gene
    * @params endGene, 8 character string representing ending gene
    * @params bank, list of all possible valid mutations
    * @return min number of mutations needed to result in ending gene as integer
    */
    public int minMutation(String startGene, String endGene, String[] bank) {
        //endGene not in the bank of valid mutations
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        char[] geneChars = new char[] {'A', 'C', 'G', 'T'};
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();
                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                for (int j = 0; j < currentGene.length(); j++) {
                    for (char geneChar : geneChars) {
                        String mutatedGene = currentGene.substring(0, j) + geneChar + currentGene.substring(j + 1);
                        //check for valid mutation
                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            visited.add(mutatedGene);
                            queue.offer(mutatedGene);
                        }
                    }
                }
            }
            mutations++;
        }

        return -1;
    }
}
