import java.util.* ;
import java.io.*; 


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items,(a,b)->{
            double val1=(double)a.value/(double)a.weight;
            double val2=(double)b.value/(double)b.weight;
            if(val1<val2) return 1;
            else if(val1>val2) return -1;
            return 0;
        });
        double ans=0;
      
        for(int i=0;i<n;i++){
            if(w>=items[i].weight){
                ans+=items[i].value;
                w-=items[i].weight;
            }else {
                ans+=((double)items[i].value/(double)items[i].weight)*w;
                break;
            }
        }
        return ans;
    }
}
