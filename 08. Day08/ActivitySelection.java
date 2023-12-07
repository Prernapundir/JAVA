import java.util.*;

public class Solution {
    public static class Pair implements Comparable{
        public int start;
        public int end;
        public Pair(int start,int end){
            this.start=start;
            this.end=end;
        }
        
        @Override
        public int compareTo(Object o){
            Pair p=(Pair) o;
            return this.end-p.end;
        }
    }
    
    public static int maximumActivities(
        List<Integer> start, List<Integer> end) {
        int n=start.size();

        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new Pair(start.get(i),end.get(i)));
        }
        Collections.sort(list);
        int ans=1;
        Pair pair=list.get(0);
        
        for(int i=1;i<n;i++){
            if(list.get(i).start>=pair.end){
                ans++;
                pair=list.get(i);
            }
        }
        return ans;
    }
}
