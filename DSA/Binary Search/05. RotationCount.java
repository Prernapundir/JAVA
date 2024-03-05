/*
Same approach finding min element
*/


public class Solution {
    public static int findKRotation(int []arr){
        int low=0,high=arr.length-1;
        int ans=Integer.MAX_VALUE,index=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[low]<=arr[high]){
                if(ans>arr[low]){
                    ans=arr[low];
                    index=low;
                    return index;
                }
            }
            if(arr[low]<=arr[mid]){
                if(ans>arr[low]){
                    ans=arr[low];
                    index=low;
                }
                low=mid+1;
            }else{
                if(ans>arr[mid]){
                    ans=arr[mid];
                    index=mid;
                }
                high=mid-1;
            }
            // System.out.println(ans);
        }
        return index;
    }
}
