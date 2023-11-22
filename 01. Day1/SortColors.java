class Solution {

    public void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    public void sortColors(int[] nums) {
        int i=0,j=0,k=nums.length-1;

        while(j<=k){
            if(nums[j]==1){
                j++;
            }else if(nums[j]==2){
                swap(nums,j,k);
                k--;
            }else{
                swap(nums,i,j);
                i++;
                j++;
            }
        }
    }
}
