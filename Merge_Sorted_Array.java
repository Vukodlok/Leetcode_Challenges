class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //set pointers
        int i = m - 1;
        int j = n - 1;
        int spot = n + m - 1;
        //loop through nums1
        while (j >= 0) {
            //if nums1 value is larger add to end of list and move i back one
            if (i >= 0 && nums1[i] > nums2[j]){
                nums1[spot] = nums1[i];
                i --;
            }
            //if nums2 value is larger add to end of list and move j back one
            else{
                nums1[spot] = nums2[j];
                j --;
            }
            spot--;
        }
    }
}
/*In my Python solution, which I coded first, I discovered the check at the end
are redundant and I left them off the Java solution. */
