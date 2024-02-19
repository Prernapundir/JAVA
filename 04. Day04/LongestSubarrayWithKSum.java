 import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []arr, int k) {
		Map<Integer,Integer> m=new HashMap<>();
		int ans=0;
		int sum=0;
		int j=0;

		while(j<arr.length){
			sum+=arr[j++];
			if(sum==k){
				ans=j;
			}
			if(m.containsKey(sum-k)){
				ans=Math.max(ans,j-m.get(sum-k));
			}
			if(!m.containsKey(sum)){
				m.put(sum,j);
			}
		}

		return ans;
	}
}
