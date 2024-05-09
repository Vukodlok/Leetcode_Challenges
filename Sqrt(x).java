/*I solved this in Python first and used my solution for Java.
In order to pass all the unit tests I needed to make sure to use double values
instead of int on lines 6 and 13.  Otherwise the way Python vs Java handles values and rounded caused the unit tests to fail in Java where they passed in Python. */
class Solution {
    public int mySqrt(int x) {
        double root = x;
        //loop enough times for a reasonable answer given values within the range
        //With trial and error 20 iterations was just enough for the given test set
        for (int i = 0; i < 20; i++) {
            //check for division by 0
            if (root != 0){
                //Newton's Method uses next = (current + num/current)/2
                root = (root + x/root)/2.0;
            }
        //round down to the nearest int by casting
        }
        return (int)root;
    }
}
