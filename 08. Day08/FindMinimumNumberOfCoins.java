import java.util.*;

public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        List<Integer> coins=
        Arrays.asList(1,2,5,10,20,50,100,500,1000);
        Collections.sort(coins,Collections.reverseOrder());
        
        List<Integer> ans=new ArrayList<>();
        for(Integer x: coins){
            while(n>=x){
                n-=x;
                ans.add(x);
            }
        }

        return ans;
    }
}
