class Solution {
    
    public int merge(int[] arr,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int[] temp=new int[high-low+1];
        int count=0;

        while(i<=mid && j<=high){
            if(arr[i]>2*(long)arr[j]){
                count+=mid-i+1;
                j++;
            }else i++;
        }

        i=low;
        j=mid+1;

        while(i<=mid && j<=high){
            if(arr[i]>arr[j]){
                temp[k++]=arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=high){
            temp[k++]=arr[j++];
        }

        for(k=low;k<=high;k++){
            arr[k]=temp[k-low];
        }
        return count;
    }

    public int mergeSort(int[] arr,int low,int high){
        if(low>=high) return 0;

        int mid=low+(high-low)/2;
        int count=0;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);

        return count;
    }


    public int reversePairs(int[] nums) {
        return mergeSort(nums,0,nums.length-1);
    }
}
