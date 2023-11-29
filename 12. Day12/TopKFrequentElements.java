class Solution {

    class Pair implements Comparable{
        int val;
        int freq;

        Pair(int val,int freq){
            this.val=val;
            this.freq=freq;
        }

        @Override
        public int compareTo(Object o){
            Pair p=(Pair) o;
            return this.freq-p.freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<>();

        Map<Integer,Integer> map=new HashMap<>();

        for(int x: nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }

        for(Map.Entry<Integer,Integer> x: map.entrySet()){
            minHeap.add(new Pair(x.getKey(),x.getValue()));
            if(minHeap.size()>k){
                minHeap.remove();
            }
        }
        
        int[] ans=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            Pair p=minHeap.poll();
            ans[i++]=p.val;
        }

        return ans;

    }
}
