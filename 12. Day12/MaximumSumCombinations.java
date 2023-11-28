public class Solution {
    public int[] solve(int[] a, int[] b, int k) {
        int n=a.length;
       Arrays.sort(a);
       Arrays.sort(b);

       PriorityQueue<Integer> minHeap=new PriorityQueue<>();
       int[] ans=new int[k];

       for(int i=n-1;i>=0;i--){
           for(int j=n-1;j>=0;j--){
               int val=a[i]+b[j];
                if(minHeap.size()<k){
                    minHeap.add(val);
                }else if(minHeap.peek()<val){
                    minHeap.poll();
                    minHeap.add(val);
                }else break;
           }
       }
       int i=k-1;
       while(!minHeap.isEmpty()){
           ans[i--]=minHeap.poll();
       }
       return ans;
    }
}
