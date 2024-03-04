class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1,n=nums.length;

        while(low<=high){
            int mid=low+(high-low)/2;

            int next=nums[(mid+1)%n];
            int prev=nums[(mid-1+n)%n];

            if(nums[mid]<=next && nums[mid]<=prev){
                return nums[mid];
            }
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
