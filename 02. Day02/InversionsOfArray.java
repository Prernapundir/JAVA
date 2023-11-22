import java.util.* ;
import java.io.*; 
public class Solution {

    public static long merge(int low,int high,int mid,long arr[]){
        int i=low;
        int j=mid+1;
        int k=0;
        long temp[]=new long[high-low+1];
        long count=0;

        while(i<=mid && j<=high){
            if(arr[i]>=arr[j]){
                temp[k++]=arr[j];
                count+=mid-i+1;
                j++;
            }else{
                temp[k++]=arr[i];
                i++;
            }
        }
        while(i<=mid){
            temp[k++]=arr[i];
            i++;
        }
        while(j<=high){
            temp[k++]=arr[j];
            j++;
        }

        for(int p=low;p<=high;p++){
            arr[p]=temp[p-low];
        }
        return count;
    }

    public static long mergeSort(int low,int high,long arr[]){
        if(low>=high) return 0;
        long count=0;

        int mid=low+(high-low)/2;
        count+=mergeSort(low,mid,arr);
        count+=mergeSort(mid+1,high,arr);
        count+=merge(low,high,mid,arr);
        return count;
    }

    public static long getInversions(long arr[], int n) {
        return mergeSort(0,n-1,arr);

    }
}
