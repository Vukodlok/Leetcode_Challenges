import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> digits = new ArrayList<>();
    public static int result;
    public boolean isHappy(int n) {
        //used to store current iteration of happy number calculation
        result = n;
        //used to store a set of already seen numbers from result
        HashSet<Integer> repeats = new HashSet<>();
        //loop until result is 1 or pattern repeats
        while (result != 1 && !(repeats.contains(result))){
            //add result to the reapeats set
            repeats.add(result);
            //split the number into digits
            splitDigits(result);
            //clear result for storing new int after calculation
            result = 0;
            //perform squaring and sum
            calcHappy();
        }
        return result == 1;
    }
    public void splitDigits(int num) {
        digits.clear();
        //split num into individual digits and add to the set digits
        while (num > 0) {
            int digit = num % 10;
            digits.add(digit);
            num /= 10;
        }
    }
    public void calcHappy() {
        //perform squaring and sum
        for (int num : digits){
            result += Math.pow(num, 2);
        }
    }
}
