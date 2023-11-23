import java.io.*;
import java.util.* ;

public class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		Map<Integer,Integer> m=new HashMap<>();
		int ans=0;
		int sum=0;
		int j=0;

		while(j<arr.size()){
			sum+=arr.get(j);
			if(sum==0){
				ans=j+1;
			}
			if(m.containsKey(sum)){
				ans=Math.max(ans,j-m.get(sum));
			}else{
				m.put(sum,j);
			}
			j++;
		}

		return ans;
		
	}
}
