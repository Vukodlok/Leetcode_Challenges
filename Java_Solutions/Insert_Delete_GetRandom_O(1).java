/*
* Leetcode Challenge: Insert Delete GetRandom O(1)
*
* Implement the RandomizedSet class:
* RandomizedSet() Initializes the RandomizedSet object.
* bool insert(int val) Inserts an item val into the set if not present. 
* Returns true if the item was not present, false otherwise.
* bool remove(int val) Removes an item val from the set if present. 
* Returns true if the item was present, false otherwise.
* int getRandom() Returns a random element from the current set of elements 
* (it's guaranteed that at least one element exists when this method is called). 
* Each element must have the same probability of being returned.
* You must implement the functions of the class such that 
* each function works in average O(1) time complexity.
*
* 6/30/24
* Mark Robuck
*/
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
import java.util.*;

class RandomizedSet{
    private Map<Integer, Integer> dict;
    private List<Integer> list;
    private Random rand;
    /*
    * Implement the RandomizedSet class
    */
    public RandomizedSet(){
        dict = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }
    /*
    * Insert an item into a set if not present.
    * @params val, integer to be inserted into the set
    * @return true if item was inserted, false otherwise
    */
    public boolean insert(int val) {
        if (dict.containsKey(val)){
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }
    /*
    * Remove an item from a set if present.
    * @params val, integer to be removed from the set
    * @return true if item was removed, false otherwise
    */
    public boolean remove(int val) {
        if (!dict.containsKey(val)){
            return false;
        }
        //move the element we want deleted to the end
        int i = dict.get(val);
        int last = list.get(list.size() - 1);
        list.set(i, last);
        dict.put(last, i);
        //remove the last element
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }
    /*
    * Selected a value from the set at random.
    @return value of the element randomly selected
    */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
