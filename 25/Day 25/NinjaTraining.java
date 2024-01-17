public class Solution {

    public static int recur(
        int n,int points[][],int i,int j,int[][] dp){
        if(i>=n) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int op1=0;
        for(int k=0;k<3;k++){
            if(k!=j){
                int ans=recur(n,points,i+1,k,dp)+points[i][k];
                op1=Math.max(ans,op1);
            }
            
        }
        return dp[i][j]=op1;
    }

    public static int ninjaTraining(int n, int points[][]) {

        int[][] dp=new int[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                dp[i][j]=-1;
            }
        }
        return recur(n,points,0,3,dp);
    }

}
