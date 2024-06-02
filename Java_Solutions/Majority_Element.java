/*
* Leetcode Challenge: Majority Element
*
* array nums of size n, return the majority element.
*
* The majority element is the element that appears more than ⌊n / 2⌋ times. 
* You may assume that the majority element always exists in the array.
*
* 6/2/24
* Mark Robuck
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    /*
    * find the element in a list that appears at least half the time
    *
    * @params nums, list of ints to be checked
    * @return, the element that appears at least half the time
    * - We are told this will always exist in our data
    */
    public int majorityElement(int[] nums) {
        //copy the array into an ArrayList
        List<Integer> numbers = new ArrayList<>();
        for(int i : nums) {
            numbers.add(i);
        }
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : numbers) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        // Iterate through the HashMap to find the element with the highest frequency
        int mostFrequent = -1;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mostFrequent = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }
        // Return the most frequent element
        return mostFrequent;     
    }
}
