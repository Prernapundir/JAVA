/*striver approach */

class Solution {
    public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(low<high && nums[low]==nums[high]){ // for duplicates
            low++;
        }
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[low]<=nums[high]){
                ans=Math.min(ans,nums[low]);
                break;
            }

            if(nums[low]==nums[high]){
                low++;
                continue;
            }
            
            if(nums[mid]>=nums[low]){
                ans=Math.min(ans,nums[low]);
                low=mid+1;
            }else{
                ans=Math.min(ans,nums[mid]);
                high=mid-1;
            }
        }
        return ans;
    }
}