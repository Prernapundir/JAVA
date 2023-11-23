class Solution {
    int recur(int m,int n,int x,int y,int[][] dp){
       if(x>=m || y>=n) return 0;
       if(x==m-1 && y==n-1) return 1;
       
       if(dp[x][y]!=-1) return dp[x][y];

       int op1=recur(m,n,x+1,y,dp);
       int op2=recur(m,n,x,y+1,dp);
       return dp[x][y]=op1+op2;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return recur(m,n,0,0,dp);
    }
}
