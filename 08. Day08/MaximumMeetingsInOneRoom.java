import java.util.*;

public class Solution {
    public static class Pair implements Comparable{
        int start;
        int end;
        Pair(int start,int end){
            this.start=start;
            this.end=end;
        }

        @Override
        public int compareTo(Object o){
            Pair p=(Pair) o;
            return this.end-p.end;
        }
    }

    public static int maximumMeetings(int []start, int []end) {
        int n=start.length;
        Pair[] list=new Pair[n];
        for(int i=0;i<n;i++){
            list[i]=new Pair(start[i],end[i]);
        }

        Arrays.sort(list);
        int ans=1;
        Pair p=list[0];
        for(int i=1;i<n;i++){
            if(list[i].start>p.end){
                ans++;
                p=list[i];
            }
        }
        return ans;

    }
}
