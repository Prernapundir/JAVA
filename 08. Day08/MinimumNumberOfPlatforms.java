import java.util.*;
public class Solution {
  

    public static int calculateMinPatforms(int at[], int dt[], int n) {
        int[] arr=new int[50000+5];
        Arrays.fill(arr,0);

        for(int i=0;i<n;i++){
            arr[at[i]]++;
            arr[dt[i]+1]--;
        }
        int count=0,ans=0;

        for(int x: arr){
            count+=x;
            ans=Math.max(count,ans);
        }

        return ans;
    }
}
