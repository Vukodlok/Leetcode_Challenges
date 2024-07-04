/*
* Leetcode Challenge: Trapping Rain Water
*
* Given n non-negative integers representing an elevation map 
* where the width of each bar is 1, 
* compute how much water it can trap after raining.
*
* 7/4/24
* Mark Robuck
*/
class Solution{
    /*
    * Compute a specific area.
    * @params height, list of block heights as integers
    * @return amount of rain that can be trapped, in blocks as integers
    */
    public int trap(int[] height) {
        //if list is empty or no water is trapped
        if (height == null || height.length < 3) {
            return 0;
        }
        int left= 0;
        int right = height.length - 1;
        int water = 0;
        int left_max = height[left];
        int right_max = height[right];
        
        while (left < right){
            //check if next height is greater than last
            if (height[left] < height[right]) {
                //check if height is greater than current max peak
                if (height[left] > left_max) {
                    //set new max peak
                    left_max = height[left];
                }
                //otherwise add the amount of water in this basin to the total
                else {
                    water += left_max - height[left];
                }
                left++;
            }
            //if right is not greater than left
            else {
                //check if height is greater than current max peak
                if (height[right] >= right_max) {
                    //set new max peak
                    right_max = height[right];
                }
                //otherwise add the amount of water in this basin to the total
                else {
                    water += right_max - height[right];
                }
                right--;
            }
        }
        return water;
    }
}
