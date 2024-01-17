import java.util.* ;
import java.io.*; 
public class Solution {

    public static int recur(int[] dp,int n,int heights[],int i){

        if(i>=heights.length) return 0;

        if(dp[i]!=-1) return dp[i];
        int op1=Integer.MAX_VALUE,op2=Integer.MAX_VALUE;


        if(i+1<n){
            op1=recur(dp,n,heights,i+1) + Math.abs(heights[i]-heights[i+1]);
        }
        if(i+2<n){
            op2=recur(dp,n,heights,i+2) + Math.abs(heights[i]-heights[i+2]);
        }
        return dp[i]=Math.min(op1,op2)==Integer.MAX_VALUE?0:Math.min(op1,op2);
    }
    
    public static int frogJump(int n, int heights[]) {
       int[] dp=new int[n];

       Arrays.fill(dp, -1);
       return recur(dp,n,heights,0);
    }

}
