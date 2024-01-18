import java.util.*;

public class Solution {
      public static int mod=1000000007;
	  public static int recur(
        int m,int n,int dp[][],ArrayList<ArrayList<Integer>> mat){
		if(m==0 && n==0) return 1;
		if(m<0 || n<0 || mat.get(m).get(n)==-1) return 0;

		if(dp[m][n]!=-1) return dp[m][n];
		
		int right=recur(m-1,n,dp,mat);
		int down=recur(m,n-1,dp,mat);

		return dp[m][n]=(right+down)%mod;
	}

    public static int mazeObstacles(
		int n, int m, ArrayList<ArrayList<Integer>> mat) {
        int[][] dp=new int[n+1][m+1];
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				dp[i][j]=-1;
			}
		}
		return recur(n-1,m-1,dp,mat);
    }

}

