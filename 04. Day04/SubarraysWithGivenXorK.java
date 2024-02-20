import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int b) {
		Map<Integer,Integer> map=new HashMap<>();
        int xor=0,count=0;
        for(int i=0;i<arr.size();i++){
            xor=xor^arr.get(i);
            int y=xor^b;
            if(xor==b) count++;
            if(map.containsKey(y)) {
                count+=map.get(y);
            }
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        return count;
	}
}
