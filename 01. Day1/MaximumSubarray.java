class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum=0;
        int ans=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            curr_sum+=nums[i];
            ans=Math.max(ans,curr_sum);
            if(curr_sum<0) curr_sum=0;
        }

        return ans;
    }
}
