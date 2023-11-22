class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=nums1.length-1;
        int i=nums1.length-n-1;
        int j=n-1;

        while(j>=0 && k>=0){
            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k--]=nums1[i];
                i--;
            }else{
                nums1[k--]=nums2[j];
                j--;
            }
        }
    }
}
