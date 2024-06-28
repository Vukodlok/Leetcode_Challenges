/*
* Leetcode Challenge: H-Index
*
* Given an array of integers citations where citations[i] is the number of citations 
* a researcher received for their ith paper, return the researcher's h-index.
* According to the definition of h-index on Wikipedia: 
* The h-index is defined as the maximum value of h such that 
* the given researcher has published at least h papers 
* that have each been cited at least h times.
*
* 6/28/24
* Mark Robuck
*/
import java.util.Arrays;

class Solution{
    /*
    * Given an array find the h-index, max value s.t. at least h values are h or greater.
    * @params citations, list of citation amounts as integers
    * @return h-index
    */
    public int hIndex(int[] citations) {
        //sort the list for easier calculations later
        Arrays.sort(citations);
        
        int n = citations.length;
        for (int i = 0; i < n; i++){
            //starting from the end, 
            //do we have at least the quantity of the current value in the list
            int h = n - i;
            //check for h-index criteria
            if (citations[i] >= h){
                return h;
            }
        }
        return 0; 
    }
}
