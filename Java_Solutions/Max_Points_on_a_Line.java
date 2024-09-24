/*
* Leetcode Challenge: Max Points on a Line
*
* Given an array of points where points[i] = [xi, yi] represents a 
* point on the X-Y plane, return the maximum number of points that 
* lie on the same straight line.
*
* 9/24/24
* Mark Robuck
*/
import java.util.HashMap;
import java.util.Map;

class Solution {
    /*
    * Find max number of points on a line.
    * @params points, list of x, y coordinates
    * @return max number of points in the list on a straight line
    */
    public int maxPoints(int[][] points) {
        //one or no point, return the number of points
        if (points.length <= 2) {
            return points.length;
        }

        int maxPoints = 1;
        
        //iterate over each point to calculate collinear points
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopes = new HashMap<>();
            int duplicates = 0;
            int localMax = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicates++;
                    continue;
                }
                
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                String slope = dy + "/" + dx;
                slopes.put(slope, slopes.getOrDefault(slope, 0) + 1);
                localMax = Math.max(localMax, slopes.get(slope));
            }
            maxPoints = Math.max(maxPoints, localMax + duplicates + 1);
        }
        return maxPoints;
    }

    //function to compute the greatest common divisor (GCD)
    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
