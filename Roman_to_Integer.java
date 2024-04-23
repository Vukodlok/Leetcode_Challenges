import java.util.HashMap;
import java.util.Map;

class Solution {
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
