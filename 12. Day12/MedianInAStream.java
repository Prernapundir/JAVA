import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int[] ans=new int[n];
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<n;i++){
            maxHeap.add(arr[i]);
            minHeap.add(maxHeap.poll());

            if(minHeap.size()>maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }

            if((i&1)==1){
                ans[i]=(minHeap.peek()+maxHeap.peek())/2;
            }else ans[i]=maxHeap.peek();
        }

        return ans;
    }
}
