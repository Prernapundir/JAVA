class Solution {
    public int recur(int[] nums,int i,int n,int[] dp){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];

        int op1=recur(nums,i+1,n,dp);
        int op2=recur(nums,i+2,n,dp)+nums[i];

        return dp[i]=Math.max(op1,op2);
    }

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        int op1= recur(nums,0,nums.length-1,dp);
        Arrays.fill(dp,-1);
        int op2=recur(nums,1,nums.length,dp);
        return Math.max(op1,op2);
    }
}
