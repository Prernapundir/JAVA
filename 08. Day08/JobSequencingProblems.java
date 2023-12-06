import java.util.*;
public class Solution {
    public static int[] jobScheduling(int [][]jobs) {
        int n=jobs.length;
        int size=0;
        for(int[] job: jobs){
            size=Math.max(size,job[1]);
        }
        int profit=0;
        int jobs_count=0;
        int[] dp=new int[size];
        Arrays.fill(dp,-1);

        Arrays.sort(jobs,(a,b)->b[2]-a[2]);


        for(int i=0;i<n;i++){
            for(int j=jobs[i][1]-1;j>=0;j--){
                if(dp[j]==-1){
                    dp[j]=1;
                    profit+=jobs[i][2];
                    jobs_count++;
                    break;
                }
            }
        }
        int[] ans=new int [2];
        ans[0]=jobs_count;
        ans[1]=profit;
        return ans;
    }
}
