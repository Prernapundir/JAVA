class Solution {
    public int recur(int[] nums,int i,int[] dp){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];

        int op1=recur(nums,i+1,dp);
        int op2=recur(nums,i+2,dp)+nums[i];
        return dp[i]=Math.max(op1,op2);
    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return recur(nums,0,dp);
    }
}
