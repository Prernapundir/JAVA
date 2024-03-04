/*
Approach 
1. Just find which part is the sorted half , 
how to find ?? find mid then check with left part if arr[mid]>arr[low, means left part is sorted
else right part is sorted 
2. Now we decided which part is sorted , so check if target lies in sorted part or not , then move
accordingly left or right
*/

class Solution {
    public int search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[low]){
                if(target>=nums[low] && target<=nums[mid]){
                    high=mid-1;
                }else low=mid+1;
            }else{
                if(target>=nums[mid] && target<=nums[high]){
                    low=mid+1;
                }else high=mid-1;
            }
        }
        return -1;
    }
}
