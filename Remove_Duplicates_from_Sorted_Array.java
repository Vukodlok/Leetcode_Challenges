class Solution {
    public int removeDuplicates(int[] nums) {
        //create two pointers for start and end of the array
        int left = 0;
        int right = nums.length - 1;
        //check for empty or single value arrays
        if (nums.length <= 1) {
            return nums.length;
        }
        //loop through initial list
        while (left <= right) {
            //continue to check for duplicates
            while (left < right && nums[left] == nums[left+1]) {
                //shift left duplicate to the end of the list and everything else one left
                int temp = nums[left];
                for (int i = left; i < right; i++) {
                    nums[i] = nums[i+1];
                }
                nums[right] = temp;
                right--;
            }
            left++;
        }
        return left;
    }
}
/*This solution was incredibilty inefficient compared to others. A better solution was the following:
        int i=1;
        for(int j=1; j<nums.length; j++){
            if(nums[j] != nums[j-1]){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
*/
