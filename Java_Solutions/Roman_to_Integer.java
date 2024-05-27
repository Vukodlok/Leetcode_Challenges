/*
* Leetcode Challenge: Roman to Integer
* 
* Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
* 
* Symbol       Value
* I             1
* V             5
* X             10
* L             50
* C             100
* D             500
* M             1000
*
* Given a roman numeral, convert it to an integer.
* 
* 4/26/24
* Mark Robuck
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    * Take a string representing a roman numeral and convert it to an integer value
    * @parma s, roman numeral as a string
    * @return roman numeral as an integer value
    */
    public int romanToInt(String s) {
        //create a mapping of roman nuemrals to integers
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int total = 0; //total value of integer

        //loop through the given string
        for(int i = 0; i < s.length(); i++) {
            int current = romanValues.get(s.charAt(i));
            //look for subtraction patterns
            if (i < s.length() - 1) {
                int next = romanValues.get(s.charAt(i+1));
                if (current < next) {
                    //this is a subtraction pattern
                    total += (next - current);
                    //skip the next character
                    i++;
                    continue;
                }
            }
            //if not part of subtraction pattern add next value to the total
            total += current;
        }
        return total;
    }
}
