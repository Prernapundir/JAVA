import java.util.* ;
import java.io.*; 

public class Solution {
    public static ArrayList<Integer> ans=new ArrayList<>();
    public static void recur(int num[],int i,int sum){
        if(i>=num.length){
            ans.add(sum);
            return;
        }
        recur(num,i+1,sum);
        sum+=num[i];
        recur(num,i+1,sum);
    }
    public static ArrayList<Integer> subsetSum(int num[]) {
       recur(num,0,0);
       Collections.sort(ans);
       return ans;
    }
}
