import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int repeat=-1; 
        int sum=n*(n+1)/2,curr_sum=0;
        for(int i=0;i<arr.size();i++){
            int num=Math.abs(arr.get(i));
            curr_sum+=Math.abs(arr.get(i));
            if(arr.get(num-1)<0){
                repeat=num;
            }else{
                arr.set(num-1,-arr.get(num-1));
            }
        }

        int diff=Math.abs(curr_sum-repeat);
        int missing=Math.abs(diff-sum);
        int[] ans=new int[2];
        ans[0]=missing;
        ans[1]=repeat;
        return ans;
    }
}
